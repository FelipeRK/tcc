package com.catolicasc.org.daos;

import javax.persistence.TypedQuery;

import com.catolicasc.org.entities.User;

public class UserDao extends GenericDao<User>{

	public UserDao() {
		super(User.class);
	}

	public User verifyLoginInfo(String username, String password) {
		super.em = super.emf.createEntityManager();
		User result = null;
		String query = "SELECT t FROM User t WHERE email = \'" + username + "\' AND password = \'" + password + "\'";
		TypedQuery<User> q1 = super.em.createQuery(query, User.class);
		if (q1.getResultList().size() >0)
			result = q1.getResultList().get(0);
		super.em.close();
		return result;
	}
}
