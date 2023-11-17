package com.management.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.management.dto.User;

public class UserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Villian");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public User saveUser(User user ) 
	{
		et.begin();
		em.persist(user);
		et.commit();
		return user;
	}
	
	public User findUser(int userid) 
	{
		User exuser = em.find(User.class, userid);
		return exuser;
	}
	
	public User deleteUser(int uid) 
	{
		User exu = em.find(User.class, uid);
		em.remove(exu);
		return exu = em.find(User.class, uid);
		
	}
	
	public User updateUser(User adto,int id)
	{
		User exu = em.find(User.class, id);
		if(exu != null)
		{
			adto.setUid(exu.getUid());
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
