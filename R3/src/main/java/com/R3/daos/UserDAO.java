package com.R3.daos;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.hibernate.SessionFactory;

import com.R3.beans.UserBean;

public class UserDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void create(UserBean user){}
	public void delete(UserBean user){}
	public void update(UserBean user){}
	public List<UserBean> findAllUsers(){
		throw new UnsupportedOperationException();
	}
	public void findOne(UserBean user){
		throw new UnexpectedTypeException();
	}
}
