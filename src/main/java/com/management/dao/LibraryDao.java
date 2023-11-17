package com.management.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.management.dto.Library;

public class LibraryDao 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Villian");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Library saveLibrary(Library lib ) 
	{
		et.begin();
		em.persist(lib);
		et.commit();
		return lib;
	}
	
	public Library findLibrary(int lid) 
	{
		Library exlibrary = em.find(Library.class, lid);
		return exlibrary;
	}
	
	public Library deleteLibrary(int lid) 
	{
		Library exlibrary = em.find(Library.class, lid);
		em.remove(exlibrary);
		return exlibrary = em.find(Library.class, lid);
		
	}
	
	public Library updateLibrary(Library ldto,int id)
	{
		Library exlibrary = em.find(Library.class, id);
		if(exlibrary != null)
		{
			ldto.setLibraryid(exlibrary.getLibraryid());
			et.begin();
			em.merge(ldto);
			et.commit();
			return exlibrary;
		}
		else {
			return null;
		}
		
	}

	
}
