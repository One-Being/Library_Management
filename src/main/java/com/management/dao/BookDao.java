package com.management.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.management.dto.Book;


public class BookDao
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Villian");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Book saveBook(Book bok ) 
	{
		et.begin();
		em.persist(bok);
		et.commit();
		return bok;
	}
	
	public Book findBook(int bid) 
	{
		Book exbook = em.find(Book.class, bid);
		return exbook;
	}
	
	public Book deleteBook(int bid) 
	{
		Book exbook = em.find(Book.class, bid);
		em.remove(exbook);
		return exbook = em.find(Book.class, bid);
		
	}
	
	public Book updateBook(Book bdto,int id)
	{
		Book exbook = em.find(Book.class, id);
		if(exbook != null)
		{
			bdto.setBookid(exbook.getBookid());
			et.begin();
			em.merge(bdto);
			et.commit();
			return exbook;
		}
		else {
			return null;
		}
		
	}

}
