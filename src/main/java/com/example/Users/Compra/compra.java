package com.example.Users.Compra;

import com.example.Users.repository.userOrdersRepository;

public class compra implements iCompra {

    @Override
    public Double selecionaMenorPrecoCompra(Double Preco, Long IdStock,
            userOrdersRepository repository) {
        return repository.selecionaMenorPrecoCompra(IdStock);
    }

    @Override
    public Double selecionaMaiorPrecoCompra(Double Preco, Long IdStock,
            userOrdersRepository repository) {

        return repository.selecionaMenorPrecoCompra(IdStock);
    }

}