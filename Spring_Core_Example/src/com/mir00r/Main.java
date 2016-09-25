/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        // XML based configuraiotn 
        
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/mir00r/beans.xml");
//
//        Hello hel = (Hello) context.getBean("hello");
//
//        hel.setMessage("Hello Spring World");
//        System.out.println(hel.getMessage());
//
//        // Annotation based configuration example
//        ApplicationContext context2 = new AnnotationConfigApplicationContext(Hello_Configuration_MB.class);
//
//        Hello hel2 = (Hello) context2.getBean("hello");
//
//        hel2.setMessage("Hello Spring World 2 -----");
//        System.out.println(hel2.getMessage());
         
        
        // Dependency Injection Example using Constructor
//       ApplicationContext ac = new ClassPathXmlApplicationContext("com/mir00r/beans.xml");
//       Employee em = (Employee) ac.getBean("emp");
//       em.show();
    
    // Bean Lifecycle Example how bean init and destroy
//    AbstractApplicationContext aac = new ClassPathXmlApplicationContext("com/mir00r/beans.xml");
//    aac.registerShutdownHook(); // forcefully Shutdown AbstractApplicationContext class
//    
//    Hello hel = (Hello) aac.getBean("hello");
//
//    hel.setMessage("Hello Spring World");
//    System.out.println(hel.getMessage());
    
    ApplicationContext ac = new ClassPathXmlApplicationContext("com/mir00r/beans.xml");
       //ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("com/mir00r/beans.xml"); 
       Employee em = (Employee)ac.getBean("emp2");
       em.show();
    }
}
