package com.catolicasc.org.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDER")
public class Order implements GenericEntity{

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
	private List<OrderedProduct> orderedProductList;
	@Column(name="delivery_address")
	private String deliveryAddress;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="coupon_id")
	private Coupon coupon;
	@Column(name="remarks")
	private String remarks;
	
	public Order() {
		super();
	}

	public Order(User user, List<OrderedProduct> orderedProductList, String deliveryAddress, Coupon coupon,
			String remarks) {
		super();
		this.user = user;
		this.orderedProductList = orderedProductList;
		this.deliveryAddress = deliveryAddress;
		this.coupon = coupon;
		this.remarks = remarks;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderedProduct> getOrderedProductList() {
		return orderedProductList;
	}
	public void setOrderedProductList(List<OrderedProduct> orderedProductList) {
		this.orderedProductList = orderedProductList;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
