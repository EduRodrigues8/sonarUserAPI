package com.example.Users.Compra;

import com.example.Users.repository.userOrdersRepository;

public interface iCompra {
    Double selecionaMenorPrecoCompra(Double Preco, Long IdStock, userOrdersRepository repository);

    Double selecionaMaiorPrecoCompra(Double Preco, Long IdStock, userOrdersRepository repository);
}