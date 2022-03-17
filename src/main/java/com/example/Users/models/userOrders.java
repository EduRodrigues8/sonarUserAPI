package com.example.Users.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_orders")
public class userOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "id_user")
	private Long id_user;
	@Column(name = "email")
	private String email;
	@Column(name = "id_stock")
	private Long id_stocks;
	@Column(name = "stock_symbol")
	private String stock_symbol;
	@Column(name = "stock_name")
	private String stock_name;
	@Column(name = "volume")
	private Long volume;
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

	public Long getId_stock() {
		return id_stocks;
	}

	public void setId_stock(Long id_stocks) {
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

	public void setVolume(Long volume) {
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

}
