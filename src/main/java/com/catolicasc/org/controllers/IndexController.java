package com.catolicasc.org.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.catolicasc.org.controllersBo.IndexControllerBo;
import com.catolicasc.org.objects.IndexProduct;

@Controller
public class IndexController {
	
	@Resource(name="indexControllerBo")
	IndexControllerBo indexControllerBo;
	
	@RequestMapping(value="/")
	public String goToIndex(HttpServletRequest request, HttpSession session){
		List<IndexProduct> allDisplayProducts = indexControllerBo.getAllIndexProduct();
		return setIndexProductBasicDisaplays(request, allDisplayProducts);
	}

	@RequestMapping(value = "/category")
	public String goToCategory(@RequestParam("categoryName") String categoryName, HttpServletRequest request, HttpSession session) {
		List<IndexProduct> categoryDisplayProducts = indexControllerBo.getAllIndexProductByCategory(categoryName);
		return setIndexProductBasicDisaplays(request, categoryDisplayProducts);
	}

	@RequestMapping(value = "/buscar")
	public String findProducts(@RequestParam("searchKeyword") String keyword, HttpServletRequest request, HttpSession session) {
		List<IndexProduct> searchDisplayProducts = indexControllerBo.getAllIndexProductBySearch(keyword);
		return setIndexProductBasicDisaplays(request, searchDisplayProducts);
	}
	
	private String setIndexProductBasicDisaplays(HttpServletRequest request, List<IndexProduct> data) {
		request.setAttribute("indexProductBasicDisaplays", data);
		return "index";
	}
}
