package com.example.Users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.example.Users.dto.StockDTO;

@Service
public class StockService {

    @Autowired
    WebClient webClient;

    @RequestMapping("/orders")
    @GetMapping
    public user_StockBalancesService search(@PathVariable Long id, @RequestHeader("Authorization") String acessToken) {
        System.out.println("Funcionou!!");
        Mono<user_StockBalancesService> monoStock = this.webClient
                .method(HttpMethod.GET)
                .uri("/stock/{id}", id)
                .header(HttpHeaders.AUTHORIZATION, acessToken)
                .retrieve()
                .bodyToMono(user_StockBalancesService.class);
        monoStock.subscribe(s -> {
        });
        user_StockBalancesService stock = monoStock.block();
        return stock;
    }

    public StockDTO search1(Long id, @RequestHeader("Authorization") String acessToken) {
        Mono<StockDTO> monoStock = this.webClient
                .method(HttpMethod.GET)
                .uri("/stock/{id}", id)
                .header(HttpHeaders.AUTHORIZATION, acessToken)
                .retrieve()
                .bodyToMono(StockDTO.class);

        StockDTO stock = monoStock.block();
        return stock;
    }

}