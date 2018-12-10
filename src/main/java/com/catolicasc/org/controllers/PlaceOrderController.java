package com.catolicasc.org.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

import com.catolicasc.org.controllersBo.PlaceOrderControllerBo;
import com.catolicasc.org.entities.Order;
import com.catolicasc.org.entities.OrderedProduct;
import com.catolicasc.org.entity.bo.OrderBo;

@Controller
@SessionAttributes("order")
public class PlaceOrderController {

	@Resource(name="placeOrderControllerBo")
	PlaceOrderControllerBo placeOrderControllerBo;
	@Resource(name="orderBo")
	OrderBo orderBo;
	
	@RequestMapping(value="/deliveryInfoForm", method = RequestMethod.POST)
	public String goToDeliveryInfoFormPage(HttpServletRequest request, HttpSession session) {
		return "deliveryInfoForm";
	}

	@RequestMapping(value="/confirmationPage", method = RequestMethod.POST)
	public String goToConfirmationPage(ModelMap model, HttpServletRequest request, HttpSession session) {
		List<OrderedProduct> orderedProducts = placeOrderControllerBo.createOrderedProductByShoppingCart(session);
		Order createdOrder = placeOrderControllerBo.createNewOrderByInfo(request, session, orderedProducts);
		model.addAttribute("order", createdOrder);
		
		request.setAttribute("order", createdOrder);
		
		return "confirmationPage";
	}

	@RequestMapping(value="/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(ModelMap model, HttpServletRequest request, HttpSession session) {
		Order order = (Order) model.get("order");
		
		Order confirmedOrder = placeOrderControllerBo.confirmOrder(session, order);
		double totalAmount = orderBo.calculateOrderTotalCost(confirmedOrder);
		
		request.setAttribute("confirmedOrder", confirmedOrder);
		request.setAttribute("totalAmount", totalAmount);
		return "orderSummaryPage";
	}

}
