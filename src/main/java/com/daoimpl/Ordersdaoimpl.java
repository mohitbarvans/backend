package com.daoimpl;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Cartdao;
import com.dao.Ordersdao;
import com.model.Orders;
import com.model.Product;

@Repository("Ordersdaoimpl")
public class Ordersdaoimpl implements Ordersdao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public Ordersdaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void insert(Orders order)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(order);
		session.getTransaction().commit();
	}
	
	
	
}
