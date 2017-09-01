package com.R3.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

@Aspect
public class UserControllerValidation {
	private static Logger log = Logger.getRootLogger();
	private static final String allTests = "execution( * test*(..) )";
	
	@Around(value="execution(create(UserBean user))") 
	public void validateCreate(ProceedingJoinPoint joinpoint)
	{
		
	}
	
//	@Around(value=getters)
//	public Object aroundMethod(ProceedingJoinPoint joinpoint){
//		Object returnedValue = null;
//		System.out.println("[BEFORE] Aspect intercepted " 
//				+ joinpoint.getSignature());
//		System.out.println("At this location: " + joinpoint.getTarget());
//		// before 
//		System.out.println("Before " + joinPoint.getSignature());
//		// call method
//		try {
//			returnedValue = joinPoint.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		// after
//		System.out.println("After " + joinwPoint.getSignature());
//		//returnedValue = "BAAAAA";
//		throw new RuntimeException();
//		return returnedValue;
//	}

}
