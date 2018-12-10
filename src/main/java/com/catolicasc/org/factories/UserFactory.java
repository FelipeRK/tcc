package com.catolicasc.org.factories;

import java.util.List;

import com.catolicasc.org.entities.Order;
import com.catolicasc.org.entities.User;

public class UserFactory {

	public User createUser(String username, String password, String email, String address, List<Order> orderList) {
		return new User(username, password, email, address, orderList);
	}
	
	public User createUser() {
		return new User();
	}
}
