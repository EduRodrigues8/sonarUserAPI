package com.example.Users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.Users.models.userStockBalances;
import com.example.Users.repository.user_stockBalanceRepository;

@RestController
@CrossOrigin
public class UserStockBalanceController {

    @Autowired
    private user_stockBalanceRepository userStockBalanceRepository;

    public List<userStockBalances> listar() {
        return userStockBalanceRepository.findAll();
    }

}