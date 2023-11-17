package com.management.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.management.dto.Admin;

public class AdminDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Villian");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Admin saveAdmin(Admin adm ) 
	{
		et.begin();
		em.persist(adm);
		et.commit();
		return adm;
	}
	
	public Admin findAdmin(int aid) 
	{
		Admin exadmin = em.find(Admin.class, aid);
		return exadmin;
	}
	
	public Admin deleteAdmin(int aid) 
	{
		Admin exadmin = em.find(Admin.class, aid);
		em.remove(exadmin);
		return exadmin = em.find(Admin.class, aid);
		
	}
	
	public Admin updateAdmin(Admin bdto,int id)
	{
		Admin exadmin = em.find(Admin.class, id);
		if(exadmin != null)
		{
			bdto.setAdminid(exadmin.getAdminid());
			et.begin();
			em.merge(bdto);
			et.commit();
			return exadmin;
		}
		else {
			return null;
		}
		
	}


}
