package com.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.userdao;
import com.model.User;

public class Userdaoimpl implements userdao{

@Autowired
SessionFactory sessionFactory;

@Autowired
public Userdaoimpl(SessionFactory sessionFactory)
{
	super();
	this.sessionFactory=sessionFactory;
}
@Transactional
public void insertUser(User user)
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.persist(user);
	session.getTransaction().commit();
	
	}

public User findUserByEmail(String email)
{
	Session session=sessionFactory.openSession();
	User u=null;
	try{
	session.beginTransaction();
	u=(User) session.get(User.class, email);
	session.getTransaction().commit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return u;
}
}
