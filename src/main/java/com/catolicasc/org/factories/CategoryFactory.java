package com.catolicasc.org.factories;

import java.util.List;

import com.catolicasc.org.entities.Category;
import com.catolicasc.org.entities.Product;

public class CategoryFactory {
	public Category createCategory(String categoryName, List<Product> productList) {
		return new Category(categoryName, productList);
	}
}
