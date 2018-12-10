package com.catolicasc.org.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements GenericEntity{

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;
	@Column(name="username", unique=true)
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Order>orderList;
	
	public User() {
		super();
	}

	public User(String username, String password, String email, String address, List<Order> orderList) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.orderList = orderList;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}	
}
