package com.catolicasc.org.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catolicasc.org.daos.UserDao;
import com.catolicasc.org.entities.User;

@Controller
public class LoginController {
	
	@Resource(name="userDao")
	UserDao userDao;
	
	@RequestMapping(value="/login-usuario")
	public String loginIndex(HttpServletRequest request, HttpSession session) {
		return "userLogin";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginUser(HttpServletRequest request, HttpSession session) {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		User user = userDao.verifyLoginInfo(username, password);
		if(user != null) {
			session.setAttribute("user", user);
			return "redirect:minha-conta";
		} else {
			request.setAttribute("loginError", "Informacoes invalidas. Por favor, tente novamente.");
			return "userLogin";
		}
	}

	@RequestMapping(value="/sair")
	public String logOut(HttpServletRequest request, HttpSession session) {
		session.removeAttribute("user");
		
		String referer = request.getHeader("Referer");
		return "redirect:"+ referer;
	}

}
