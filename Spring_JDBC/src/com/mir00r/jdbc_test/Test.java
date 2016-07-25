/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.jdbc_test;

import com.mir00r.jdbc_dao.EdSupportDao;
import com.mir00r.jdbc_dao.EmployeeDao;
import com.mir00r.jdbc_dao.HibernateDao;
import com.mir00r.jdbc_model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/mir00r/jdbc_test/Spring-JDBC.xml");
    
        EmployeeDao employeeDao = (EmployeeDao) ac.getBean("employeeDao");
        EdSupportDao edSupportDao = (EdSupportDao) ac.getBean("edSupprotDao");
        HibernateDao hibernateDao = (HibernateDao) ac.getBean("hiebernateDao");
        
        //int res = employeeDao.SaveEmployee(new Employee("Abdur Razzak", 40000));
        //int res = employeeDao.SaveEmployeeByPS(new Employee("James Bond", 40000));
       // int res = employeeDao.SaveEmployeeByNPS(new Employee("Shathi", 500000));
//        String ans = employeeDao.getEmployeeId(1);
         
       // System.out.println(res);
        


//        System.out.println(employeeDao.getAllEmployeeInfo(1).getName() + " " +
//                employeeDao.getAllEmployeeInfo(1).getSalary());

        // System.out.println(employeeDao.getAllEmployeeList(1).get(0).getName() );
        
        //System.out.println(edSupportDao.getEmployeeId(1) );
        
        System.out.println(hibernateDao.getEmployee() );
    }
}
