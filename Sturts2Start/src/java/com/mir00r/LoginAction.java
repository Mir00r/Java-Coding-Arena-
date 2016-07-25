/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
public class LoginAction extends ActionSupport{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public void validate() {
        if ( name.length() < 1 ) {
           // addFieldError(name, "Name field can't blank");
            addActionError("Name must not blank");
        }
        
        if ( password.length() < 6 ) {
            //addFieldError(password, "password must be 6 characters");
            addActionError("password must be 6 characters");
        }
        
    }
    
}
