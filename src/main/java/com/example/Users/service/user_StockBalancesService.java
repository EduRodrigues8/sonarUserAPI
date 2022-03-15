package com.example.Users.service;

import com.example.Users.models.userOrders;
import com.example.Users.models.userStockBalances;
import com.example.Users.repository.user_stockBalanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class user_StockBalancesService implements userAndStockID {
    @Autowired
    user_stockBalanceRepository repository;

    public userStockBalances buscaStockEuser(long idUser, long idStock) {
        if (repository.buscaStockEuser(idUser, idStock) == null) {
            return new userStockBalances();
        } else {
            return repository.buscaStockEuser(idUser, idStock);
        }
    }

    public userStockBalances buscaStockEuser(long idUser, long idStock, userOrders orders) {
        if (repository.buscaStockEuser(idUser, idStock) != null) {
            return repository.buscaStockEuser(idUser, idStock);
        } else {
            userStockBalances newBalance = new userStockBalances();
            newBalance.setId_stocks(idStock);
            newBalance.setId_user(idUser);
            newBalance.setStock_name(orders.getStock_name());
            newBalance.setStock_symbol(orders.getStock_symbol());
            newBalance.setVolume(0);
            repository.save(newBalance);

            return (newBalance);
        }
    }

    public userStockBalances encontraUser(long idUser) {
        return repository.encontraUser(idUser);
    }

    // @Override
    // public ResponseEntity<?> atualizaStockUser(long idUser, long idStock, long
    // volume) {
    // return ResponseEntity.ok().body(repository);
    // }

    @Override
    public userStockBalances finByUserAndStock(long idUser, long idStock) {

        return null;
    }

    @Override
    public userStockBalances finByUserAndStock(long idUser, long idStock, userOrders orders) {

        return null;
    }

    @Override
    public userStockBalances finByUser(long idUser) {

        return null;
    }

    @Override
    public ResponseEntity<?> updateStockUser(long idUser, long idStock, long volume) {
        return null;
    }

}