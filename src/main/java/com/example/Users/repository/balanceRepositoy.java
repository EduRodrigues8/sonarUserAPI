package com.example.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Users.models.userStockBalances;

@Repository
public interface balanceRepositoy extends JpaRepository<userStockBalances, Long> {
    @Query(value = "SELECT * FROM userStockBalances WHERE id = ?1", nativeQuery = true)
    userStockBalances buscaCarteira(Long id);

}