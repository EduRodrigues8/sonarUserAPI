package com.example.Users.repository;

import java.util.List;
import java.util.Optional;

import com.example.Users.models.userStockBalances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface user_stockBalanceRepository extends JpaRepository<userStockBalances, Long> {
    @Query(value = "SELECT u FROM  User_stockBalance u WHERE u.id_user = ?1 and u.id_stocks = ?2", nativeQuery = true)
    List<userStockBalances> ListbuscaStockEuser(Long id_user, Long id_stocks);

    @Query(value = "SELECT u FROM  User_stockBalance u WHERE u.id_user = ?1 and u.id_stocks = ?2", nativeQuery = true)
    userStockBalances buscaStockEuser(Long id_user, Long id_stocks);

    @Query(value = "SELECT * FROM User_stockBalance WHERE id = ?1", nativeQuery = true)
    userStockBalances buscaCarteira(Long id);

    @Query(value = "SELECT * FROM User_stockBalance WHERE id_user = ?1 and id_stocks = ?2", nativeQuery = true)
    userStockBalances busca(@Param("id_user") Long id_user, @Param("id_stocks") Long id_stocks);

    @Query(value = "SELECT * FROM user_stock_balances WHERE id_user = ?1", nativeQuery = true)
    List<userStockBalances> encontraUser(@Param("id_user") Long id_user);

    @Query(value = "SELECT * FROM user_stock_balances WHERE id_user = ?1", nativeQuery = true)
    userStockBalances atualizaStockUser(Long idUser, long idStock);

    @Query(value = "Select volume from user_stock_balances where id_user = :id_user and id_stocks = :id_stocks", nativeQuery = true)
    int findVolumeStock(@Param("id_user") long id_user, @Param("id_stock") long id_stock);

    @Query(value = "SELECT * FROM user_stock_balances  WHERE id_user= ?1", nativeQuery = true)

    List<userStockBalances> findId(Long id);

    @Query(value = "SELECT * FROM user_stock_balances  WHERE email = :email", nativeQuery = true)

    Optional<userStockBalances> findId(String email);

    @Query(value = "SELECT * FROM user_stock_balances where email = :email", nativeQuery = true)
    List<userStockBalances> encontraEmail2(String email);
}