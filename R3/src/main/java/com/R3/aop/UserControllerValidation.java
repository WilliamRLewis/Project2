package com.R3.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;

import com.R3.beans.ReviewBean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

@Aspect
public class UserControllerValidation {
	private static Logger log = Logger.getRootLogger();

	private static final String createReview = "execution(* com.R3.controllers.ReviewController.create(..))";
	
	
	@Around(value=createReview) 
	public void validateCreate(ProceedingJoinPoint joinpoint)
	{
		ReviewBean myReview = (ReviewBean) joinpoint.getArgs()[0];
		log.debug(myReview.getId() + " " + myReview.getRating());
		
		if(myReview.getRating() > 10 || myReview.getRating() < 0 )
		{
			log.error("YOU CALL THIS A RATING?!?!?");
			throw new RuntimeException();
		} else
			try {
				joinpoint.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return;
		
	}
	

}
