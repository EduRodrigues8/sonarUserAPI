package com.example.Users.dto;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.Users.models.userOrders;
import com.example.Users.models.userStockBalances;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class OrdersDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "id_user")
    private long id_user;
    @Column(name = "id_stock")
    private long id_stock;
    @Column(name = "stock_symbol")
    private String stock_symbol;
    @Column(name = "stock_name")
    private String stock_name;
    @Column(name = "volume")
    private long volume;
    @Column(name = "price")
    private Double price;
    @Column(name = "type")
    private Integer type;
    @Column(name = "status")
    private Integer status;
    @CreationTimestamp
    private Timestamp created_on;
    @UpdateTimestamp
    private Timestamp updated_on;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public long getId_stock() {
        return id_stock;
    }

    public void setId_stock(long id_stock) {
        this.id_stock = id_stock;
    }

    public String getStock_symbol() {
        return stock_symbol;
    }

    public void setStock_symbol(String stock_symbol) {
        this.stock_symbol = stock_symbol;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }

    public Timestamp getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Timestamp updated_on) {
        this.updated_on = updated_on;
    }

    public static void save(userStockBalances newBalance) {
    }

    public userOrders orElse(Object object) {
        return null;
    }

    public OrdersDto(OrdersDto orders) {
        this.id = orders.getId();
        this.id_user = orders.getId_user();
        this.id_stock = orders.getId_stock();
        this.stock_symbol = orders.getStock_symbol();
        this.stock_name = orders.getStock_name();
        this.volume = orders.getVolume();
        this.price = orders.getPrice();
        this.type = orders.getType();
        this.status = orders.getStatus();
        this.created_on = orders.getCreated_on();
        this.updated_on = orders.getUpdated_on();
    }

}