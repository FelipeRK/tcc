package com.catolicasc.org.daos;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.catolicasc.org.entities.GenericEntity;

public class GenericDao<T extends GenericEntity> {
	
	
	private final Class<T> typeParameterClass;
	@Resource(name="emf")
	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	public GenericDao(Class<T> typeParameterClass) {
		this.typeParameterClass = typeParameterClass;
	}
	
	private void setUp(){
		em = emf.createEntityManager();
	}
	
	private void cleanUp(){
		em.getTransaction().commit();
		em.close();
	}
	
	public List<T> listEntities() {
		List<T> myList;
		setUp();
		
		String query = "SELECT t FROM "+ typeParameterClass.getSimpleName() + " t";
		TypedQuery<T> q1 = em.createQuery(query, typeParameterClass);
		myList = q1.getResultList();
		em.close();
		return myList;	
	}
	
	public T getEntity(int id){
		setUp();
		T entity = em.find(typeParameterClass, id);
		em.close();
		return entity;
	}
	
	public void removeEntity(int id){
		setUp();
		T entity = em.find(typeParameterClass, id);
		em.getTransaction().begin();
		em.remove(entity);
		cleanUp();
	}
	
	public T addOrUpdateEntity(T entity){
		setUp();
		em.getTransaction().begin();
		T mergedEntity = em.merge(entity);
		cleanUp();
		return mergedEntity;
	}
	
}
