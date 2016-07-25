/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.test;

import com.mir00r.service.EmpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/mir00r/test/spring-aop.xml");

        EmpService ems = ac.getBean("empservice", EmpService.class);

//        System.out.println(ems.getManager().getName());
//        System.out.println(ems.getAccountant().getName());

//        ems.getManager().setName("Abdur Razzak");
//        ems.getAccountant().setName("Rajib Khan");

        // ems.getManager().setNameReturn("Abdur Razzak");
        ems.getManager();
    }
}
