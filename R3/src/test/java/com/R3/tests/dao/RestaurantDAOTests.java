package com.R3.tests.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.R3.beans.RestaurantBean;
import com.R3.beans.UserBean;
import com.R3.daos.RestaurantDAO;
import com.R3.daos.UserDAO;

public class RestaurantDAOTests {
	
	private static ApplicationContext context;
	RestaurantDAO dao;
	
	@Test
	public void testCreate(){
		dao = context.getBean("RestaurantDAO", RestaurantDAO.class);
		RestaurantBean aRant = new RestaurantBean(1,"MacDonalds", "Fast Food", "1331 palindrome dr VA 20002", "noon-noon", 2001-10-02, null, "Was It A Rat I Saw?", null);
		dao.create(aRant);
	}
	

}
