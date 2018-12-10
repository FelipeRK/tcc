package com.catolicasc.org.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catolicasc.org.daos.ProductDao;
import com.catolicasc.org.entities.Product;

@Controller
public class ProductDetailController {
	@Resource(name="productDao")
	ProductDao productDao;

	@RequestMapping(value="/detalhe-produto")
	public String goToProductDetail(@RequestParam("id") int productId, HttpServletRequest request, HttpSession session){
		Product product = productDao.getEntity(productId);
		request.setAttribute("product", product);
		return "productDetail";
	}
}
