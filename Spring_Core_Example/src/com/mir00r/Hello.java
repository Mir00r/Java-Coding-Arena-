/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
public class Hello {

//public class Hello implements InitializingBean, DisposableBean{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @PostConstruct
    public void init () {
        System.out.println("Before Initializing Bean-------");
    }
    
    @PreDestroy
    public void clear () {
        System.out.println("Before Destroy Beans-+-+-+-+");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Before Initializing Bean------- 2");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Before Destroy Beans-+-+-+-+ 2 ");
//    }
    
    
}
