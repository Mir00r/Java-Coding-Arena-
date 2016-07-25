/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.service;

import com.mir00r.model.LoginBean;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
@Service
public class LoginService {
    public String performLogin ( LoginBean loginCredentials ) 
            throws IncorrectLoginCredentialsException {
        
        if ( loginCredentials.getLoginName() != null && 
                loginCredentials.getLoginName().trim().equalsIgnoreCase("admin") 
                && loginCredentials.getPassword() != null && 
                loginCredentials.getPassword().trim().equalsIgnoreCase("123") ) {
            
            return "success";
        }
        else {
            throw new IncorrectLoginCredentialsException();
        }
    }
    
    public void createNewAccount ( LoginBean loginBean ) throws IncorrectLoginCredentialsException {
        if ( loginBean.getLoginName() != null && 
                loginBean.getLoginName().trim().equalsIgnoreCase("") 
                && loginBean.getPassword() != null && 
                loginBean.getPassword().trim().equalsIgnoreCase("") ) {
            throw new IncorrectLoginCredentialsException();
        }
        
        // Implement rest of the bussiness logic 
        System.out.println(loginBean.getLoginName());
    }
}
