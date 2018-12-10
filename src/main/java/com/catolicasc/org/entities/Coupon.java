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
@Table(name="COUPON")
public class Coupon implements GenericEntity{

	@Id
	@GeneratedValue
	@Column(name = "coupon_id")
	private int id;
	@Column(name="coupon_code")
	private String couponCode;
	@Column(name="coupon_rate")
	private double couponRate;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "coupon")
	private List<Order> orderWhichUsedCoupon;
	
	public Coupon() {
		super();
	}

	public Coupon(String couponCode, double couponRate) {
		super();
		this.couponCode = couponCode;
		this.couponRate = couponRate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public double getCouponRate() {
		return couponRate;
	}
	public void setCouponRate(double couponRate) {
		this.couponRate = couponRate;
	}
}
