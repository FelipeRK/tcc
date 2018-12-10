package com.catolicasc.org.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.catolicasc.org.controllersBo.ShoppingCartControllerBo;

@Controller
public class ShoppingCartController {

	@Resource(name="shoppingCartControllerBo")
	ShoppingCartControllerBo shoppingCartControllerBo;
	
	@RequestMapping(value="/carrinho")
	public String goToShoppingCart(HttpServletRequest request, HttpSession session) {
		return "shoppingCart";
	}

	@RequestMapping(value="/addShoppingCart", method = RequestMethod.POST)
	public String addToShoppingCart(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity, HttpServletRequest request, HttpSession session) {
		shoppingCartControllerBo.addToShoppingCart(productId, quantity, request, session);
		
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}

	
}
