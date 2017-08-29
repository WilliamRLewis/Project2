package com.R3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LogWatch {

	private static final String getters = 
			"execution( * get*(..))";
	private static final String allTests = 
			"execution( * test*(..) )";
	private static final String inTesting =
			"within(com.R3.tests.dao.*)";
	private static final String inUserController =
			"within(com.R3.controllers.*)";
	
	@Before(value=allTests)
	public void interceptBeforeComputeMethod(JoinPoint joinpoint){
		System.out.println("[BEFORE] Aspect intercepted " 
				+ joinpoint.getSignature());
		System.out.println("At this location: " + joinpoint.getTarget());

	}
	@Before(value="execution( * save(..))")
	public void savingObject(JoinPoint joinpoint){
		System.out.println("About to save a user!");
	}
	@Before(value=inUserController)
	public void inUserController(JoinPoint joinpoint){
		System.out.println("In userController doing " + joinpoint.getTarget());
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