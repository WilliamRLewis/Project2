package com.R3.tests.dao;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.R3.beans.ReviewBean;
import com.R3.daos.ReviewDAO;

public class ReviewDAOTests {
	ReviewDAO myDAO;
	ReviewBean aReview;
	
	@BeforeClass
	public void setup(){
		aReview = new ReviewBean();
	}
	
	@Test
	public void test(){
		//BeanFactory deprecated
		//changed to Abstract to show shutdown
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("dao-beans.xml");
		
		
	}
	@Test
	public void testCreateAndGet(){
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("dao-beans.xml");
		
		myDAO.create(aReview);
		
		System.out.println(myDAO.find(aReview));
		
	}
	
	@AfterClass
	public void shutdown(){
		aReview = null;
	}

}
