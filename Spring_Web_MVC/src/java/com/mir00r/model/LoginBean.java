/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.model;

import java.io.Serializable;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 6182390898687671093L;
    
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
