package com.catolicasc.org.factories;

import com.catolicasc.org.entities.Coupon;

public class CouponFactory {
	public Coupon createCoupon(String couponCode, double couponRate) {
		return new Coupon(couponCode, couponRate);
	}
}
