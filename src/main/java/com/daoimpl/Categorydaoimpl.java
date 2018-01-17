package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.Categorydao;
import com.model.Category;
import com.model.Supplier;

@Repository
@Service
public class Categorydaoimpl implements Categorydao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public Categorydaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void insertCategory(Category category)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(category);
		session.getTransaction().commit();
	}

	public List<Category> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Category> li=session.createQuery("from Category").list();
		session.getTransaction().commit();
		return li;
	}
	
	public Category findByCatId(int cid)
	{
	Session session=sessionFactory.openSession();
	Category c=null;
	try{
	session.beginTransaction();
	c= (Category) session.get(Category.class, cid);
	session.getTransaction().commit();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		session.getTransaction().rollback();
	}
	return c;
	}

	public void deleteCat(int cid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Category c=null;
		c= (Category) session.get(Category.class, cid);
		session.delete(c);
		session.getTransaction().commit();
	}
}
