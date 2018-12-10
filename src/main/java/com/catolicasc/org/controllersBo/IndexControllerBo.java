package com.catolicasc.org.controllersBo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.catolicasc.org.daos.CategoryDao;
import com.catolicasc.org.daos.ProductDao;
import com.catolicasc.org.daos.ProductImageDao;
import com.catolicasc.org.entities.Category;
import com.catolicasc.org.entities.Product;
import com.catolicasc.org.entities.ProductImage;
import com.catolicasc.org.factories.IndexProductFactory;
import com.catolicasc.org.objects.IndexProduct;


public class IndexControllerBo {

	@Resource(name="productDao")
	ProductDao productDao;
	@Resource(name="productImageDao")
	ProductImageDao productImageDao;
	
	@Resource(name="categoryDao")
	CategoryDao categoryDao;
	
	@Resource(name="indexProductFactory")
	IndexProductFactory indexProductFactory;
	
	public List<IndexProduct> getAllIndexProduct() {
		List<IndexProduct> allDisplayProducts = new ArrayList<>();
		List<Product> products = productDao.listEntities();
		return setIndexProductsByProductList(allDisplayProducts, products);
	}

	public List<IndexProduct> getAllIndexProductByCategory(String categoryName) {
		List<IndexProduct> displayCategoryProducts = new ArrayList<>();
		Category category = categoryDao.getCategoryByName(categoryName);
		List<Product> categoryProducts  = new ArrayList<>();
		if(category != null) {
			categoryProducts = category.getProductList();
		}
		return setIndexProductsByProductList(displayCategoryProducts, categoryProducts);
	}
	
	public List<IndexProduct> getAllIndexProductBySearch(String searchKeyword) {
		List<IndexProduct> allDisplayProducts = new ArrayList<>();
		List<Product> products = productDao.listEntities();
		List<Product> filteredProducts = filteredProductListByKeyword(products, searchKeyword);
		return setIndexProductsByProductList(allDisplayProducts, filteredProducts);
	}
	
	private List<IndexProduct> setIndexProductsByProductList(List<IndexProduct> displayProducts, List<Product> products){
		for(Product p : products) {
			int productId = p.getId();
			String productName = p.getProductName();
			double price = p.getPrice();
			String thumbnail = "";
			List<ProductImage> productImages = productImageDao.listProductImagesByProductId(productId);
			if (productImages.size() > 0)
				thumbnail = productImages.get(0).getImageLink();
			IndexProduct temp = indexProductFactory.createIndexPageBasicProductDisplay(productId, productName, price, thumbnail);
			displayProducts.add(temp);
		}
		
		return displayProducts;
		
	}

	private List<Product> filteredProductListByKeyword(List<Product> products, String keyword){
		List<Product> filteredProducts = new ArrayList<>();
		for (Product p : products) {
			if (p.getProductName().contains(keyword) || p.getProductDescription().contains(keyword)) {
				filteredProducts.add(p);
			}
		}
		return filteredProducts;
	}
}
