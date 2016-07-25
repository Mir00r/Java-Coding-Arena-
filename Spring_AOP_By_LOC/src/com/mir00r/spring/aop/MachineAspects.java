package com.mir00r.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MachineAspects {
	@DeclareParents( value = "com.mir00r.spring.aop.*", defaultImpl = com.mir00r.spring.aop.MachineWear.class )
	private IMachine machine;
	
	
	@Around("within(com.mir00r.spring.aop.*)")
	public void RunMachine( ProceedingJoinPoint jp ){
		System.out.println("Running........");
		
		try {
			jp.proceed();
		} 
		catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(".....Completed");
	}
}
