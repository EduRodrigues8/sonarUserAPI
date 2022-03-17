package com.example.Users.Compra.Venda;

import com.example.Users.repository.userOrdersRepository;

public interface iVenda {
    Double selecionaMaiorPrecoVenda(Double Preco, Long IdStock, userOrdersRepository repository);

    Double selecionaMenorPrecoVenda(Double Preco, Long IdStock, userOrdersRepository repository);

}