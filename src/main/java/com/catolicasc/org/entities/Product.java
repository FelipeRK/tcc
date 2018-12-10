package com.catolicasc.org.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product implements GenericEntity{
	
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int id;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_description")
	private String productDescription;
	@Column(name="stock")
	private int stock;
	@Column(name="price")
	private double price;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	private List<ProductImage> productImageList;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "productList")
	private List<Category> categoryList;
	
	
	public Product() {
		super();
	}
	
	public Product(String productName, String productDescription, int stock, double price,
			List<ProductImage> productImageList, List<Category> categoryList) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.stock = stock;
		this.price = price;
		this.productImageList = productImageList;
		this.categoryList = categoryList;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<ProductImage> getProductImageList() {
		return productImageList;
	}

	public void setProductImageList(List<ProductImage> productImageList) {
		this.productImageList = productImageList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
}
