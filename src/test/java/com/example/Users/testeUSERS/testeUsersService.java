package com.example.Users.testeUSERS;

import com.example.Users.service.userService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
 
@RunWith(SpringRunner.class)
class testeUsersService {

    @Autowired
    userService userService;

    @Test
    public void getUsers() {
    }
}