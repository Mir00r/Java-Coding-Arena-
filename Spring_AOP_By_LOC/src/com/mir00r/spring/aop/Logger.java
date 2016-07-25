package com.mir00r.spring.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	//@Pointcut("execution(* com.mir00r.spring.aop.Camera.*(..))") // Wildcard in pointcut Expression example
	/*@Pointcut("execution(* com.mir00r.spring.aop.Camera.Snap())")
	public void DummySnap(){
		
	}*/
	
	/*@Pointcut("execution(* *.*(..))")
	public void CameraActivity(){
		
	}*/	
	
	/*@Before("DummySnap()")
	public void aboutToTakePhoto (){
		System.out.println("About to take your picture....");
	}*/
	
	/*@Before("CameraActivity()")
	public void CameraRelatedActivity (){
		System.out.println("Doing somthing new about camarea related...");
	}*/
	
	// Advice type Example 
	/*@After("DummySnap()")
	public void AfterAdvice(){
		System.out.println("After Advice what are you doing......");
	}
	
	@AfterReturning("DummySnap()")
	public void AfterReturning(){
		System.out.println("After Returning i am sick....");
	}
	
	@AfterThrowing("DummySnap()")
	public void AfterThrowing(){
		System.out.println("After Throwing i ran......");
	}
	
	@Around("DummySnap()")
	public void AroundAdivice(ProceedingJoinPoint p ){
		System.out.println("Around advice (Before)....");
		
		try {
			p.proceed();
		} 
		catch (Throwable e) {
			System.out.println("In around advice: " + e.getMessage());
		}
		
		System.out.println("Around advice (after)....");
	}*/
	
	// Annotation specific PCD Example 
	
//	@Pointcut("within(@org.springframework.stereotype.Component com.mir00r.spring..*)")
//	public void SomePointcut (){
//		
//	}
//	
//	@Before("SomePointcut()")
//	public void SomePointcutDemo(){
//		System.out.println("-----Before Demo-------");
//	}
	
	
	/*@Pointcut("@target(org.springframework.stereotype.Component)")
	public void SomePointcut(){
		
	}
	
	
	 @Before("SomePointcut()")
	 public void SomePointcutDemo() {
		 System.out.println("----Before Target Demo------");
	 }*/

	
	/* @Pointcut("@annotation(java.lang.Deprecated)")
	 	public void SomePointcut() {
	 }
	
	
	 @Before("SomePointcut()")
	 public void SomePointcutDemo() {
		 System.out.println("********** BEFORE DEMO ************");
	 }*/
	
	/*@Pointcut("@args(org.springframework.stereotype.Component)")
 		public void SomePointcut() {
	}


	 @Before("SomePointcut()")
	 public void SomePointcutDemo() {
		 System.out.println("********** BEFORE DEMO ************");
	 }*/
	
	
	
	// Getting Target Method Arguments by using joinpoint
	
	@Pointcut("target(com.mir00r.spring.aop.Camera)")
		public void SomePointcut() {
	}
	
	
	 @Before("SomePointcut()")
	 public void SomePointcutDemo( JoinPoint jp ) {
		 System.out.println("********** BEFORE DEMO ************");
		 
		 for ( Object obj: jp.getArgs() ){
			 System.out.println("Arguments is: " + obj);
		 }
			 
	 }	
	
}
