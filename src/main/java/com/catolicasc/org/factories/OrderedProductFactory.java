package com.catolicasc.org.factories;

import com.catolicasc.org.entities.OrderedProduct;
import com.catolicasc.org.entities.Product;

public class OrderedProductFactory {
	public OrderedProduct createOrderedProduct(Product product, int quantity, double price) {
		return new OrderedProduct(product, quantity, price);
	}
}
