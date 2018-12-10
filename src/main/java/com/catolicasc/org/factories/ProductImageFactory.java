package com.catolicasc.org.factories;

import com.catolicasc.org.entities.Product;
import com.catolicasc.org.entities.ProductImage;

public class ProductImageFactory {
	public ProductImage createProductImage(Product product, String image_link) {
		return new ProductImage(product, image_link);
	}
}
