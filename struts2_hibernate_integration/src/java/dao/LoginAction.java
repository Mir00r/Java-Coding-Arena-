/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import com.opensymphony.xwork2.ActionSupport;
import entity.Users;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
public class LoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;    
    UserDao dao = new UserDao();
    Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public void validate() {
        if ( user.getUname().length() == (0) ) {
            this.addFieldError("user.uname", "Name is required");
        }
        
        if ( user.getPwd().length() == (0) ) {
            this.addFieldError("user.pwd", "Password is required");
        }
    }

    @Override
    public String execute() throws Exception {
        if (dao.find(user.getUname(), user.getPwd())) {
            return SUCCESS;
        } 
        else {
            this.addActionError("Invalid username and password");
        }
        return INPUT;
    }
    
}
