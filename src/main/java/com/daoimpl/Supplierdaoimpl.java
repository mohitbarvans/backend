package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.Supplierdao;
import com.model.Product;
import com.model.Supplier;

@Repository
@Service
public class Supplierdaoimpl implements Supplierdao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public Supplierdaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void insertSupplier(Supplier supplier)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(supplier);
		session.getTransaction().commit();

	}

	
	public List<Supplier> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> li=session.createQuery("from Supplier").list();
		session.getTransaction().commit();
		return li;
	}
	
	public Supplier findBySuppId(int sid)
	{
	Session session=sessionFactory.openSession();
	Supplier s=null;
	try
	{
	session.beginTransaction();
	s = (Supplier) session.get (Supplier.class , sid);
	session.getTransaction().commit();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		session.getTransaction().rollback();
	}
	return s;
	}

	
	public void deleteSupp(int sid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Supplier s=null;
		s= (Supplier) session.get(Supplier.class, sid);
		session.delete(s);
		session.getTransaction().commit();
	}
}






