package com.example.Users.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity

@Table(name = "user_stock_balances")

public class userStockBalances implements Serializable {
	// @EmbeddedId
	// private userStock userStock;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_user;
	private Long id_stocks;
	private String stock_symbol;
	private String stock_name;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Long volume = 0L;
	@CreationTimestamp
	private Timestamp created_on;
	@UpdateTimestamp
	private Timestamp updated_on;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId_stocks() {
		return id_stocks;
	}

	public void setId_stocks(Long id_stocks) {
		this.id_stocks = id_stocks;
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

	public Long getVolume() {
		return volume;
	}

	public void setVolume(long l) {
		this.volume = (long) l;
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

	public userStockBalances(Long id, Long id_user, Long id_stocks, String stock_symbol, String stock_name, Long volume,
			Timestamp created_on, Timestamp updated_on) {
		this.id = id;
		this.id_user = id_user;
		this.id_stocks = id_stocks;
		this.stock_symbol = stock_symbol;
		this.stock_name = stock_name;
		this.volume = volume;
		this.created_on = created_on;
		this.updated_on = updated_on;

	}

	public userStockBalances() {
	}
}