package com.catolicasc.org.objects;

import java.util.Map;
import java.util.Map.Entry;

import com.catolicasc.org.entities.Product;

public class ShoppingCart {

	private Map<Product, Integer> productMap;
	private double totalAmount;

	public Map<Product, Integer> getProductMap() {
		return productMap;
	}

	public void setProductMap(Map<Product, Integer> productMap) {
		this.productMap = productMap;
		updateTotalAmount();
	}

	public double getTotalAmount() {
		return totalAmount;
	}
	
	public void updateTotalAmount() {
		this.totalAmount = 0.0;
		for(Entry<Product, Integer> item : this.productMap.entrySet()) {
			this.totalAmount += item.getKey().getPrice() * item.getValue();
		}
	}
}
