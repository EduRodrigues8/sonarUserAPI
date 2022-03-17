package com.example.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.Users.models.userModels;

@Repository
public interface user_repository extends JpaRepository<userModels, Long> {
    @Query(value = "SELECT * FROM users  WHERE email = ?1", nativeQuery = true)
    Optional<userModels> findId(String email);

    @Query(value = "SELECT * FROM users where email = :email", nativeQuery = true)
    List<userModels> encontraEmail2(String email);

    @Query(value = "select u from User u where u.userName = ?1", nativeQuery = true)
    userModels findUserByUserName(String string);
}