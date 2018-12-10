package com.catolicasc.org.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_IMAGE")
public class ProductImage implements GenericEntity{
	@Id
	@GeneratedValue
	@Column(name = "product_image_id")
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;
	@Column(name = "image_link")
	private String imageLink;
	
	public ProductImage() {
		super();
	}
	
	public ProductImage(Product product, String imageLink) {
		super();
		this.product = product;
		this.imageLink = imageLink;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String image_link) {
		this.imageLink = image_link;
	}
}
