package com.example.Users.service;

import com.example.Users.models.userOrders;
import com.example.Users.models.userStockBalances;

import org.springframework.http.ResponseEntity;

public interface userAndStockID {

    userStockBalances finByUserAndStock(long idUser, long idStock);

    userStockBalances finByUserAndStock(long idUser, long idStock, userOrders orders);

    userStockBalances finByUser(long idUser);

    ResponseEntity<?> updateStockUser(long idUser, long idStock, long volume);
}