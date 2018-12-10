package com.catolicasc.org.factories;

import java.util.List;

import com.catolicasc.org.entities.Coupon;
import com.catolicasc.org.entities.Order;
import com.catolicasc.org.entities.OrderedProduct;
import com.catolicasc.org.entities.User;

public class OrderFactory {
	public Order createOrder(User user, List<OrderedProduct> orderedProductList, String deliveryAddress, Coupon coupon,
			String remarks) {
		return new Order(user, orderedProductList, deliveryAddress, coupon, remarks);
	}
}
