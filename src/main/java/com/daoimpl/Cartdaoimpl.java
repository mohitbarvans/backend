package com.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dao.Cartdao;
import com.model.Cart;
import com.model.Product;

@Repository("Cartdaoimpl")
public class Cartdaoimpl implements Cartdao{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public Cartdaoimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void insert(Cart cart)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	public List<Cart> findBycartID(String userId)
	{
		Session session=sessionFactory.openSession();
		List<Cart> cr=null;
		try{
		session.beginTransaction();
		cr= (List<Cart>)session.createQuery("from Cart where userMailId=: email").setString("email",userId).list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cr;
	}
	
	public Cart getCartById(int cartproductId,String userEmail)
	{
		Session session=sessionFactory.openSession();
		Cart cr=null;
		try{
		session.beginTransaction();
		cr=(Cart)session.createQuery("from Cart where userMailId=:email and cartproductId=: id").setString("email", userEmail).setInteger("id", cartproductId).uniqueResult();
		session.beginTransaction();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cr;
	}
	public void deleteCart(int cartId)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Cart cr=(Cart)session.get(Cart.class,"cartId");
		session.delete(cr);
		session.getTransaction().commit();
	}
	public void updateCart(Cart cr)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(cr);
		session.getTransaction().commit();
				
		
	}
	
}