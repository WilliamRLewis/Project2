package com.R3.tests.dao;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.R3.beans.RestaurantBean;
import com.R3.beans.ReviewBean;
import com.R3.beans.UserBean;
import com.R3.daos.ImpReviewDAO;

public class ReviewDAOTests {
	private static ApplicationContext context;
	private static ImpReviewDAO dao;

	
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
		dao = context.getBean("ImpReviewDAO", ImpReviewDAO.class);
	}
	
	@Test
	public void testCreate(){
		UserBean aUser = new UserBean(1, "Bob", "Emp", "User");
		RestaurantBean aRest = new RestaurantBean(1, "Chinese", "55555 South Street", "10:00 AM", 9717775, LocalDate.now(), "Test Restaurant", aUser);
		ReviewBean aReview = new ReviewBean(1, 3, "TestReview", aRest, aUser);
		dao.create(aReview);
	}
	
	@Test
	public void testRead(){
		ReviewBean aReview = context.getBean(ReviewBean.class);
		dao.find(aReview);
		
		dao.findAll();
		
	}
	
	@Test
	public void testUpdate(){
		ReviewBean aReview = new ReviewBean();
		dao.update(aReview);
	}
	


}
