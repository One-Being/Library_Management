package com.management.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.management.dto.Issued_Book;

public class Issued_BookDao 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Villian");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Issued_Book saveIssuedBook(Issued_Book issuedbook ) 
	{
		et.begin();
		em.persist(issuedbook);
		et.commit();
		return issuedbook;
	}
	
	public Issued_Book findIssuedBook(int id) 
	{
		Issued_Book exissbook = em.find(Issued_Book.class, id);
		return exissbook;
	}
	
	public Issued_Book deleteIssuedBook(int uid) 
	{
		Issued_Book exu = em.find(Issued_Book.class, uid);
		em.remove(exu);
		return exu = em.find(Issued_Book.class, uid);
		
	}
	
	public Issued_Book updateIssuedBook(Issued_Book adto,int id)
	{
		Issued_Book exu = em.find(Issued_Book.class, id);
		if(exu != null)
		{
			adto.setBookid(exu.getBookid());
			et.begin();
			em.merge(adto);
			et.commit();
			return exu;
		}
		else {
			return null;
		}
		
	}


}
