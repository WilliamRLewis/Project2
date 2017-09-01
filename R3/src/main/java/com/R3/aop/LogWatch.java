package com.R3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.apache.log4j.Logger;

@Aspect
public class LogWatch {
	private static Logger log = Logger.getRootLogger();
	private static final String allTests = 
			"execution( * test*(..) )";
	private static final String inTesting =
			"within(com.R3.tests.dao.*)";
	private static final String inControllers = "within(com.R3.controllers.*)";
	private static final String inDAOs = "within(com.R3.daos.*)";
	
	@Before(value=allTests)
	public void interceptBeforeComputeMethod(JoinPoint joinpoint){
		System.out.println("[BEFORE] Aspect intercepted " + joinpoint.getSignature());
		System.out.println("At this location: " + joinpoint.getTarget());

	}
	@Before(value="execution( * save(..))")
	public void savingObject(JoinPoint joinpoint){
		System.out.println("About to save something in: " + joinpoint.getSignature());
	}
	@Before(value=inControllers)
	public void inUserController(JoinPoint joinpoint){
		log.error("In userController doing " + joinpoint.getSignature());
	}
	@Before(value=inDAOs)
	public void inDOAs(JoinPoint joinpoint){
		log.error("In a DAO doing " + joinpoint.getSignature() + " With args: " + joinpoint.getArgs());
	}
	@Before(value="execution(* findAll(..))")
	public void getAllUserController(JoinPoint joinpoint){
		log.debug("In userController doing " + joinpoint.getSignature() + " With args: " + joinpoint.getArgs());
		
	}
	
}