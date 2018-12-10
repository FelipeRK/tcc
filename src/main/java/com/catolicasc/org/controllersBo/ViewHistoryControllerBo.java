package com.catolicasc.org.controllersBo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.catolicasc.org.daos.OrderDao;
import com.catolicasc.org.entities.Order;
import com.catolicasc.org.entities.User;

public class ViewHistoryControllerBo {

	@Resource(name="orderDao")
	OrderDao orderDao;
	
	public List<Order> personalOrderHistory(HttpSession session) {

		User user = (User) session.getAttribute("user");
		
		return user.getOrderList();
	}

	public  Order viewOrderDetail(int orderId, HttpSession session) {
		Order order = orderDao.getEntity(orderId);
		if (order != null) {
			int orderOwnerId = order.getUser().getId();
			User user = (User) session.getAttribute("user");
			int userId = user.getId();
			if (orderOwnerId == userId) {
				return order;
			} else {
				return null;
			}
		} else
			return null;
	}

}
