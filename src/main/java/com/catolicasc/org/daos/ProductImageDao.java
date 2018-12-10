package com.catolicasc.org.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.catolicasc.org.entities.ProductImage;

public class ProductImageDao extends GenericDao<ProductImage>{

	public ProductImageDao() {
		super(ProductImage.class);
	}
	
	public List<ProductImage> listProductImagesByProductId(int productId) {
		super.em = super.emf.createEntityManager();
		
		List<ProductImage> myList = new ArrayList<>();
		String query = "SELECT t FROM ProductImage t WHERE product_id = " + productId;
		TypedQuery<ProductImage> q1 = super.em.createQuery(query, ProductImage.class);
		myList = q1.getResultList();
		super.em.close();
		return myList;	
	}
}
