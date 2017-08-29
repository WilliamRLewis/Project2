//package com.R3.tests.aop;
//
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//
//
//@Aspect
//public class TestWatch {
//
//
//	private static final String allTests = 
//			"execution( * test*(..) )";
//	private static final String inTesting =
//			"within(com.R3.tests.dao.*";
//	
//	@Before(value=allTests)
//	public void interceptBeforeComputeMethod(JoinPoint joinpoint){
//		System.out.println("[BEFORE] Aspect intercepted " 
//				+ joinpoint.getSignature());
//		System.out.println("At this location: " + joinpoint.getTarget());
//
//	}
//	@Before(value=inTesting)
//	public void launchingTests(JoinPoint joinpoin){
//		System.out.println("Entering tests");
//	}
//
//	
//}
