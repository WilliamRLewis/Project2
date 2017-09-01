package com.R3.tests.dao;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.R3.beans.UserBean;
import com.R3.daos.UserDAO;

public class UserDAOTests {
	private static ApplicationContext context;
	UserDAO dao;

	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}

	@Test
	public void testCreate(){
		dao = context.getBean("UserDAO", UserDAO.class);
		UserBean aUser = new UserBean(1, "Jeff", "Pass", "Winer");
//		UserBean aUser = new UserBean(1, "Bob", "Emp", "User");
		dao.save(aUser);
	
	}
	@Test
	public void testRead(){
		dao = context.getBean("UserDAO", UserDAO.class);
		UserBean aUser = new UserBean(1, "Bob", "Emp", "User");
		dao.findOne(aUser);
	}
	@Test
	public void testReadAll(){
		dao = context.getBean("UserDAO", UserDAO.class);
		dao.findAllUsers();
	}
	@Test
	public void testUpdateUser(){
		dao = context.getBean("UserDAO", UserDAO.class);
		UserBean aUser = new UserBean(1, "Bobby", "Emp", "User");
		dao.save(aUser);
	}
	@Test
	public void C_C_C_COMBOTEST(){
		dao = context.getBean("UserDAO", UserDAO.class);
		UserBean aUser = new UserBean(1, "Bob", "Emp", "User");
		dao.save(aUser);
		
		dao.findOne(aUser);
		aUser.setRole("Owner");
		dao.save(aUser);
		
		dao.delete(aUser);
		
		
	}
	
	

}
