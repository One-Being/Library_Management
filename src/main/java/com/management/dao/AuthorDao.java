package com.management.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.management.dto.Author;

public class AuthorDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Villian");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Author saveAuthor(Author auth ) 
	{
		et.begin();
		em.persist(auth);
		et.commit();
		return auth;
	}
	
	public Author findAuthor(int authid) 
	{
		Author exauthor = em.find(Author.class, authid);
		return exauthor;
	}
	
	public Author deleteAuthor(int authid) 
	{
		Author exauth = em.find(Author.class, authid);
		em.remove(exauth);
		return exauth = em.find(Author.class, authid);
		
	}
	
	public Author updateAuthor(Author adto,int id)
	{
		Author exauth = em.find(Author.class, id);
		if(exauth != null)
		{
			adto.setAuthid(exauth.getAuthid());
			et.begin();
			em.merge(adto);
			et.commit();
			return exauth;
		}
		else {
			return null;
		}
		
	}

}
