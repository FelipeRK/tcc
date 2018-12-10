package com.catolicasc.org.objects;

public class IndexProduct {
	private int productId;
	private String productName;
	private double price;
	private String thumbnail;
	
	public IndexProduct(int productId, String productName, double price, String thumbnail) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.thumbnail = thumbnail;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

}