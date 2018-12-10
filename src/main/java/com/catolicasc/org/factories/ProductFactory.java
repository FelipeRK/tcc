package com.catolicasc.org.factories;

import java.util.List;

import com.catolicasc.org.entities.Category;
import com.catolicasc.org.entities.Product;
import com.catolicasc.org.entities.ProductImage;

public class ProductFactory {
	public Product createProduct(String productName, String productDescription, int stock, double price,
			List<ProductImage> productImageList, List<Category> categoryList) {
		return new Product(productName, productDescription, stock, price, productImageList, categoryList);
	}
}
