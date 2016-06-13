/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.model;

import com.mir00r.util.Database;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
@ManagedBean
@SessionScoped
public class UserBean {

    private String first_name, last_name,
            email, uname, pass, regdate,
            selectedname, msg = "";

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getSelectedname() {
        return selectedname;
    }

    public void setSelectedname(String selectedname) {
        this.selectedname = selectedname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SelectItem> getFullName() {
        List<SelectItem> lval = new ArrayList<>();

        try {
            Connection myConn = Database.getConnection();
            Statement st = (Statement) myConn.createStatement();

            ResultSet myRs = null;

            String sql = "select concat(first_name, ' ', last_name "
                    + "as name from members)";

            myRs = st.executeQuery(sql);

            while (myRs.next()) {
                lval.add(new SelectItem(myRs.getString("name")));
            }
        } 
        catch (Exception exp) {
            exp.printStackTrace();
        }

        return lval;
    }

    public void fullInfo() {
        Connection myConn = null;
        Statement st = null;
        ResultSet myRs = null;

        try {
            myConn = Database.getConnection();
            st = (Statement) myConn.createStatement();

            String sql = "select * from members "
                    + "where concat(first_name, ' ', last_name)='" 
                    + selectedname + "'" ;

            myRs = st.executeQuery(sql);
            
            while ( myRs.next() ) {
                setFirst_name(myRs.getString("first_name"));
                setLast_name(myRs.getString("last_name"));
                setUname(myRs.getString("uname"));
                setEmail(myRs.getString("email"));
                setPass(myRs.getString("pass"));
                setRegdate(myRs.getString("regdate"));
            }
        } 
        catch (Exception e) {
            System.out.println("Insert Error" + e.getMessage());
        }
    }
    
    public void updateuser() {
        Connection myConn = null;
        Statement st = null;
        ResultSet myRs = null;
        try {
            myConn = Database.getConnection();
            st = (Statement) myConn.createStatement();
            int update = st.executeUpdate("update members "
                    + "set first_name='" + first_name + "', "
                    + "last_name='" + last_name + "' , "
                    + "email='" + email + "', "
                    + "pass='" + pass + "' "
                    + "where uname='" + uname + "'");
            
            if (update > 0) {
                msg = "Member Update Successful";
            } 
            else {
                msg = "Member Update Fail!";
            }
 
        } 
        catch (Exception e) {
            System.out.println("Insert Error" + e.getMessage());
        }
 
    }
    
}
