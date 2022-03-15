package com.example.Users.service;

import java.util.List;

import com.example.Users.dto.StockDTO;
import com.example.Users.models.userModels;
import com.example.Users.models.userOrders;
import com.example.Users.models.userStockBalances;
import com.example.Users.repository.userOrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class OrderService {
    userModels user;

    userModels order_user;
    userAndStockID userAndStockID;

    @Autowired
    userOrdersRepository repository;
    @Autowired
    userService userService;

    // Usado para ligar uma api à outra e ao banco de dados.
    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8095")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    public Mono<StockDto> BuscaStockPorID(Long Id) {
        return webClient.get()
                .uri("/stocks/" + Id)
                .retrieve()
                .bodyToMono(StockDTO.class);
        // System.out.println (Dto);
    }

    public ResponseEntity<?> save(userOrders userOrders, String token, String simbolo) {

        if (userOrders.getType() == 2 && checkStockBalance(userOrders)) { // venda
            System.out.print(userOrders);
            repository.save(userOrders);

            remove(userOrders);

        } else if (userOrders.getType() == 1) {// compra
            System.out.print(userOrders);
            repository.save(userOrders);
            balanceService.SalvarStock(userOrders);
            remove(userOrders);
        }

        // token
        Mono<StockDTO> stocksDto = this.webClient
                .method(HttpMethod.GET)
                .uri("/simbolo/{symbol}", simbolo)
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(StockDTO.class);
        return ResponseEntity.ok().body(userOrders);
    }

    // GET POR ID
    public userOrders buscaOrders(Long id) {
        return repository.encontraId(id).orElse(null);
    }

    private ResponseEntity<?> remove(userOrders order_recebidap) {

        userOrders order_recebida = order_recebidap;

        List<userOrders> ordersList = repository.tipoEstock(order_recebida.getType() == 1 ? 2 : 1,
                order_recebida.getId_stock(), order_recebida.getId_user());

        for (userOrders order : ordersList) {
            if (order_recebida.getType() == 1 ? order.getPrice() <= order_recebida.getPrice()
                    : order.getPrice() >= order_recebida.getPrice()) {
                while (repository.encontraId(order.getId()).getVolume() > 0
                        && repository.encontraId(order_recebida.getId()).getVolume() > 0) {

                    order = repository.encontraId(order.getId());
                    user = userService.Listar(order.getId_user());
                    order_recebida = repository.encontraId(order_recebida.getId());
                    order_user = userService.Listar(order_recebida.getId_user());
                    System.out.println(order_recebida.getVolume());
                    System.out.println(order.getVolume());

                    if (order_recebida.getType() == 1 ? order_user.getDollar_balance() >= order.getPrice()
                            : user.getDollar_balance() >= order_recebida.getPrice()) {

                        order_recebida.setVolume(order_recebida.getVolume() - 1);
                        order.setVolume(order.getVolume() - 1);
                        System.out.println(order_recebida.getVolume());
                        System.out.println(order.getVolume());

                        if (order_recebida.getType() == 1) {
                            order_user.setDollar_balance(order_user.getDollar_balance() - order.getPrice());
                            user.setDollar_balance(user.getDollar_balance() + order.getPrice());

                        } else {
                            order_user.setDollar_balance(order_user.getDollar_balance() + order_recebida.getPrice());
                            user.setDollar_balance(user.getDollar_balance() - order_recebida.getPrice());

                        }

                        if (order.getVolume() == 0) {
                            order.setStatus(2);
                        }

                        if (order_recebida.getVolume() == 0) {
                            order_recebida.setStatus(2);
                        }

                        repository.save(order);
                        repository.save(order_recebida);
                        userService.save(user);
                        userService.save(order_user);

                    } else {
                        break;
                    }

                }
            }
        }
        return ResponseEntity.ok().body(order_recebida);
    }

    private boolean checkStockBalance(userOrders userOrders) {
        Long volumeAtual;
        userStockBalances balance2 = new userStockBalances();
        List<userStockBalances> balance = balanceRepository.findAll();
        for (userStockBalances balanceTemp : balance) {

            if (balanceTemp.getId_user() == userOrders.getId_user()
                    && balanceTemp.getId_stocks() == userOrders.getId_stock()) {
                balance2 = balanceTemp;

            }
        }
        volumeAtual = balance2.getVolume();
        try {
            if (userOrders.getType() == 2) {
                System.out.println("É venda");
                if (volumeAtual >= userOrders.getVolume()) {
                    balance2.setVolume(balance2.getVolume() - userOrders.getVolume());
                    balanceRepository.save(balance2);
                    System.out.println("Tem Volume");
                    return true;
                }
            }

        } catch (NullPointerException e) {

            System.out.println(e.getMessage());
        }
        return false;
    }
}