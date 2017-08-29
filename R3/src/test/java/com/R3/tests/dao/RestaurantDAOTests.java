package com.R3.tests.dao;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.R3.beans.RestaurantBean;
import com.R3.beans.UserBean;
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
		RestaurantBean aUser = new RestaurantBean(1, "MacDonalds", "1331 palindrome dr VA 20002", "noon-noon", "aww", 763858367, LocalDate.of(2001, 10, 2), "Was It A Rat I Saw?");
		UserBean owner = new UserBean(72, "Bob", "Pass", "Winner");
		aUser= new RestaurantBean(1, "Test",  "Type",  "Address",  "10", 2, LocalDate.now(), "Descript", owner);
		dao.save(aUser);
	}
	@Ignore
	@Test
	public void testFindByRestaurant(){
		dao = context.getBean("RestaurantDAO", RestaurantDAO.class);
		RestaurantBean restaurant = new RestaurantBean();
		restaurant.setRestaurantId(1);
		dao.findByRestaurant(restaurant);
	}
	@Test
	public void testFindAll(){
		System.out.println("findAll");
		dao = context.getBean("RestaurantDAO", RestaurantDAO.class);
		dao.findAllRestaurants();
		
	}
	@Ignore
	@Test
	public void delete( ){
		dao= context.getBean("RestaurantDAO", RestaurantDAO.class);
		dao.deleteById(1);
	}
	
	
	
	

}
