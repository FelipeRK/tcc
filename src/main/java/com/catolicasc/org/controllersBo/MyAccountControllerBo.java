package com.catolicasc.org.controllersBo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.catolicasc.org.daos.UserDao;
import com.catolicasc.org.entities.User;

public class MyAccountControllerBo {

	@Resource(name="userDao")
	UserDao userDao;
	
	public boolean editUser(HttpServletRequest request, HttpSession session, User editUser) {
		User loginedUser = (User) session.getAttribute("user");
		
		String originalPw = request.getParameter("currentPassword");
		String expectedCurrentPw = loginedUser.getPassword();
		
		if(originalPw.equals(expectedCurrentPw)) {
			editUser.setId(loginedUser.getId());
			editUser.setUsername(loginedUser.getUsername());
			User user = userDao.addOrUpdateEntity(editUser);
			session.setAttribute("user", user);
			return true;
		} else {
			return false;
		}
	}
}
