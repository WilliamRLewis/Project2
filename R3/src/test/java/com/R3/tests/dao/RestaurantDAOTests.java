package com.R3.tests.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.R3.beans.RestaurantBean;
import com.R3.daos.RestaurantDAO;


public class RestaurantDAOTests {
	
	private static ApplicationContext context; 
	RestaurantDAO dao;
	
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	@Test
	public void testCreate(){
		System.out.println("dfsfds");
		dao = context.getBean("RestaurantDAO", RestaurantDAO.class);
		RestaurantBean aUser = new RestaurantBean("MacDonalds", "1331 palindrome dr VA 20002", "noon-noon", "aww", 763858367, "2001-10-02", "Was It A Rat I Saw?");
		dao.create(aUser);
	}
	
	@Test
	public void testFindByRestaurant(RestaurantBean restaurant){
		dao = context.getBean("RestaurantDAO", RestaurantDAO.class);
		dao.findByRestaurant(restaurant);
	}
	@Test
	public void testFindAll(){
		System.out.println("findAll");
		dao = context.getBean("RestaurantDAO", RestaurantDAO.class);
		dao.findAllRestaurants();
		
	}
	@Test
	public void delete(RestaurantBean restaurant){
		dao= context.getBean("RestaurantDAO", RestaurantDAO.class);
		dao.delete(restaurant);
	}
	
	
	
	

}
