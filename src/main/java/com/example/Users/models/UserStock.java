package com.example.Users.models;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserStock implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_user")

    private userModels user;
    private Long id_stocks;

    public UserStock(userModels user, Long id_stocks) {
        this.user = user;
        this.setId_stocks(id_stocks);
    }

    public Long getId_stocks() {
        return id_stocks;
    }

    public void setId_stocks(Long id_stocks) {
        this.id_stocks = id_stocks;
    }

    public UserStock() {

    }

}
