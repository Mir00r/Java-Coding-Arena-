/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.dao;

import com.mir00r.model.User;
import com.mir00r.util.Database;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
public class UserDao {

    private Connection myConn;

    public UserDao() {
        myConn = Database.getConnection();
    }

    public void CheckUser(User user) {
        try {
            PreparedStatement myPs = myConn.prepareStatement("select uname from users where uname = ?");
            myPs.setString(1, user.getUname());

            ResultSet myRs = myPs.executeQuery();
            if (myRs.next()) {
                UpdateUser(user);
            } else {
                AddUser(user);
            }
        } 
        catch (Exception exp) {
            System.out.println("Found Error in Check method" + exp.getMessage());
        }
    }

    public void UpdateUser(User user) {
        try {
            PreparedStatement myPs = myConn.prepareStatement("update users "
                    + "set password=?, email=?, registeredon=? "
                    + " where uname=? ");

            System.out.println(new java.sql.Date(user.getRegisteredon().getTime()));
            // Set Perameter

            myPs.setString(1, user.getPassword());
            myPs.setString(2, user.getEmail());
            myPs.setDate(3, new java.sql.Date(user.getRegisteredon().getTime()));
            myPs.setString(4, user.getUname());

            myPs.executeUpdate();
        } 
        catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    public void AddUser(User user) {
        try {
            PreparedStatement myPs = myConn.prepareStatement("insert into "
                    + "users(uname, password, email, registeredon) "
                    + " values (?, ?, ?, ?) ");

            // Set Perameter
            myPs.setString(1, user.getUname());
            myPs.setString(2, user.getPassword());
            myPs.setString(3, user.getEmail());
            myPs.setDate(4, new java.sql.Date(user.getRegisteredon().getTime()));

            myPs.executeUpdate();
        } 
        catch (SQLException exp) {
            exp.printStackTrace();
        }
    }

    public void DeleteUser ( String userid) {
        try {
            PreparedStatement myPs = myConn.prepareStatement("delete from users where uname = ?");
            myPs.setString(1, userid);
            myPs.executeUpdate();
        } 
        catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    
    public List< User > GetAllUsers() {
        List< User > users = new ArrayList<>();

        try {
            Statement myStm = (Statement) myConn.createStatement();

            ResultSet myRs = myStm.executeQuery("select * from users");

            while (myRs.next()) {
                User user = new User();

                user.setUname(myRs.getString("uname"));
                user.setPassword(myRs.getString("password"));
                user.setEmail(myRs.getString("email"));
                //user.setRegisterdon(myRs.getDate("registeredon"));
                user.setRegisteredon(myRs.getDate("registeredon"));
                users.add(user);
            }
        } 
        catch (SQLException exp) {
            exp.printStackTrace();
        }

        return users;
    }

    public User GetUserById(String userid) {
        User user = new User();

        try {
            PreparedStatement myPs = myConn.prepareStatement("select * from users where uname = ?");
            myPs.setString(1, userid);
            
            ResultSet myRs = myPs.executeQuery();
            
            if ( myRs.next() ) {
                user.setUname(myRs.getString("uname"));
                user.setPassword(myRs.getString("password"));
                user.setEmail(myRs.getString("email"));
                //user.setRegisterdon(myRs.getDate("registeredon"));
                user.setRegisteredon(myRs.getDate("registeredon"));
            }
        } 
        catch (SQLException exp) {
            exp.printStackTrace();
        }
        return user;
    }
}
