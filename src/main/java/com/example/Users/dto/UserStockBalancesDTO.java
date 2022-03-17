package com.example.Users.dto;

import lombok.Data;
// import lombok.Data;
import lombok.Getter;
import lombok.Setter;
// import com.example.user.models.userStock;
// import com.example.user.models.user_stockBalance;
// import com.example.user.models.user;

@Data
@Getter
@Setter
public class UserStockBalancesDTO {
    private Long id_user;
    private Long id_stock;
    private String stock_symbol;
    private String stock_name;
    private Integer volume;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_stock() {
        return id_stock;
    }

    public void setId_stock(Long id_stock) {
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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public UserStockBalancesDTO(Long id_user, Long id_stock, String stock_symbol, String stock_name, Integer volume) {
        this.id_user = id_user;
        this.id_stock = id_stock;
        this.stock_symbol = stock_symbol;
        this.stock_name = stock_name;
        this.volume = volume;
    }
}