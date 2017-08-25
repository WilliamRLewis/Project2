package com.R3.tests.dao;

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
	ImpReviewDAO dao;

	
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	
	@Test
	public void testCreate(){
		dao = context.getBean("ImpReviewDAO", ImpReviewDAO.class);
		UserBean aUser = new UserBean(1, "Bob", "Emp", "User");
		RestaurantBean aRest = new RestaurantBean();
		ReviewBean aReview = new ReviewBean(1, 3, "TestReview", aRest, aUser);
		dao.create(aReview);
	}
	
	@Test
	public void testRead(){
		dao = context.getBean("ImpReviewDAO", ImpReviewDAO.class);
		ReviewBean aReview = context.getBean(ReviewBean.class);
		
	}


}
