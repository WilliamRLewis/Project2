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
		UserBean owner = new UserBean(72, "Bob", "Pass", "Winner");
		RestaurantBean aRest= new RestaurantBean(84, "Test",  "Type",  "Address",  "10", 2, LocalDate.now(), "Descript", owner);
		
		ReviewBean aReview = new ReviewBean(1, 3, "TestReview", aRest, owner);
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
