package com.example.Users.controller;

import java.util.List;
import com.example.Users.repository.user_repository;
import com.example.Users.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Users.models.userModels;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private user_repository userRepository;
    @Autowired
    private userService service;

    @GetMapping
    public List<userModels> listaUser() {
        return userRepository.findAll();
    }

    // Retorna mensagens de erro para campos "obrigatórios".

    @PostMapping
    public ResponseEntity<?> save(@RequestBody userModels users) {
        System.out.println(users.getUsername());
        if (users.getDollar_balance() <= 0.99) {
            return ResponseEntity.badRequest().body("O campo 'Dollar_balance' não pode ser menor ou igual à R$0.99");
        }
        if (users.getUsername() == "") {
            return ResponseEntity.badRequest().body("O campo 'Username' não pode estar vazio!");
        }
        if (users.getPassword() == "") {
            return ResponseEntity.badRequest().body("O campo 'Password' não pode estar vazio!");
        }

        // se não houver erros, não aparecerá mensagem.

        else {
            users = service.save(users);
            return ResponseEntity.ok().body(users);
        }
    }
}