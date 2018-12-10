package com.catolicasc.org.entity.bo;

import java.util.List;

import com.catolicasc.org.entities.Order;
import com.catolicasc.org.entities.OrderedProduct;

public class OrderBo {

	public double calculateOrderTotalCost(Order order) {
		
		double result = 0.0;
		List<OrderedProduct> orderedProductList = order.getOrderedProductList();
		
		for(OrderedProduct product : orderedProductList) {
			result += product.getPrice() * product.getQuantity();
		}
		
		double couponDiscountRate = 1.0;
		if(order.getCoupon() != null) {
			couponDiscountRate = order.getCoupon().getCouponRate();
		}
		
		return result * couponDiscountRate;
	}

}
