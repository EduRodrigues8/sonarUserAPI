package com.example.Users.Compra.Venda;

import com.example.Users.repository.userOrdersRepository;

public class venda implements iVenda {

    @Override
    public Double selecionaMaiorPrecoVenda(Double Preco, Long IdStock,
            userOrdersRepository repository) {

        return repository.selecionaMaiorPrecoVenda(IdStock);
    }

    @Override
    public Double selecionaMenorPrecoVenda(Double Preco, Long IdStock,
            userOrdersRepository repository) {

        return repository.selecionaMenorPrecoCompra(IdStock);
    }

}