/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.aspect;

import com.mir00r.model.Manager;
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

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
//@Aspect
//@Component
public class EmpAspect {
    // @Before("execution( public String getName() )")
    //@Before("execution( * get*(..) )") // Wildcard annotation
    // @Before("allGettersDummy () && allManagerDummy () ")

//    @Before(" allManagerDummy () ")
//
//    //public void beforeAdvice () {
//    public void beforeAdvice(JoinPoint joinpoint) { // Detect which method actually working 
//        System.out.println("Aspect Is Running----------------------------" 
//                + joinpoint.toString()); // Detect which method actually working 
//
//        System.out.println("Aspect Is Running----------------------------");
//
//        Manager manager = (Manager) joinpoint.getTarget();
//    }

    /*
    // @Before(" args(String) ")
    @Before(" args(name) ")
    public void stringArgMethod(String name) {
        // System.out.println("Method run with string args...." );
        System.out.println("Method run with string args..with value...." + name);
    }

    @After(" args(name) ")
    public void afterArgMethod(String name) {
        // System.out.println("Method run with string args...." );
        System.out.println("Aftre Method run with string args..............with value............" + name);
    }
    
        @Before("execution( public String getName() )")
    @Before("allGettersDummy ()")
    public void beforeAdvice2() {
        System.out.println("Aspect 2 Is Running+++++++++++++++++++++++++");
    }
    
    */
    
   // @AfterReturning(" args(name) ")
//     @AfterReturning( pointcut = " args(name) " , returning = "ReturnValue" )
//    public void afterRetArgMethod(String name, String ReturnValue ) {
//        // System.out.println("Method run with string args...." );
//        System.out.println("Aftre Returnong Method .......with value............" 
//                + name + " Return Value = " + ReturnValue);
//    }
//    
//    @AfterThrowing(" args(name) ")
//    public void afterThrowMethod(String name) {
//        // System.out.println("Method run with string args...." );
//        System.out.println("Aftre Throwing Method .......with value............");
//    }


    //@Pointcut("execution( * get*(..) )")
    public void allGettersDummy() {
    }

//    @Pointcut("within( com.mir00r.model.Manager )")
//    public void allManagerDummy() {
//    }
    
    //@Around("allGettersDummy()")
    public void AroundAdvice ( ProceedingJoinPoint proceedingJoinPoint ) {
        try {
            System.out.println("Before advice ");
            proceedingJoinPoint.proceed();
            System.out.println("After Returning");
        } catch (Throwable e) {
            System.out.println("After Throwable");
        }
        System.out.println("Finally -----");
       
    }
}
