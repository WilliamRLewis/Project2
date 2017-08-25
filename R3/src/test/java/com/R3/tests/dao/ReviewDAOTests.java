package com.R3.tests.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.R3.beans.ReviewBean;
import com.R3.daos.ImpReviewDAO;
import com.R3.daos.ReviewDAO;

public class ReviewDAOTests {
	private static ApplicationContext context;
	ImpReviewDAO dao;

	
	@BeforeClass
	public static void initialize(){
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	
	@Test
	public void test(){
		dao = context.getBean("ImpReviewDAO", ImpReviewDAO.class);
		ReviewBean aReview = new ReviewBean(1, 2, "test", 1, 2); 
		dao.create(aReview);
	}
//	@Test
//	public void testCreateAndGet(){
//		AbstractApplicationContext context = 
//				new ClassPathXmlApplicationContext("dao-beans.xml");
//		
//		myDAO.create(aReview);
//		
//		System.out.println(myDAO.find(aReview));
//		
//	}
	
//	@AfterClass
//	public void shutdown(){
//		aReview = null;
//	}

}
