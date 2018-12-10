package com.catolicasc.org.daos;

import javax.persistence.TypedQuery;

import com.catolicasc.org.entities.Category;

public class CategoryDao extends GenericDao<Category>{

	public CategoryDao() {
		super(Category.class);
	}

	public Category getCategoryByName(String categoryName) {
		super.em = super.emf.createEntityManager();
		Category result = null;
		String query = "SELECT t FROM Category t WHERE category_name = \'" + categoryName + "\'";
		TypedQuery<Category> q1 = super.em.createQuery(query, Category.class);
		if (q1.getResultList().size() >0)
			result = q1.getResultList().get(0);
		super.em.close();
		
		return result;
	}

}
