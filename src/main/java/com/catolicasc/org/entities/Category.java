package com.catolicasc.org.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "CATEGORY")
public class Category implements GenericEntity {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int id;
	@Column(name = "category_name")
	private String categoryName;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "RWA_CATEGORY_PRODUCT", joinColumns = { 
			@JoinColumn(name = "category_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private List<Product> productList;

	public Category() {
		super();
	}

	public Category(String categoryName, List<Product> productList) {
		super();
		this.categoryName = categoryName;
		this.productList = productList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
