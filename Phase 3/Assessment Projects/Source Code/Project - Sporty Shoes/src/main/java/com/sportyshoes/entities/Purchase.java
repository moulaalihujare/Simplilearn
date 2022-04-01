package com.sportyshoes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	@ManyToOne
	private User user;
	@ManyToOne
	private Product product;
	public Purchase(String date, int price, User user, Product product) {
		super();
		this.date = date;
		this.user = user;
		this.product = product;
	}
	public Purchase() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", date=" + date + ", user=" + user + ", product=" + product
				+ "]";
	}
}
