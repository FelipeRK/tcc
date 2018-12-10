package com.catolicasc.org.factories;

import com.catolicasc.org.objects.IndexProduct;

public class IndexProductFactory {
	public IndexProduct createIndexPageBasicProductDisplay(int productId, String productName, double price, String thumbnail) {
		return new IndexProduct(productId, productName, price, thumbnail);
	}
}
