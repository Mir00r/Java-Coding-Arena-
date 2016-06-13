/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mir00r.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author Abdur Razzak <abdur.razzaq06@gmail.com>
 */
public class Database {
    public static Connection getConnection () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = (Connection) 
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/loginapp", 
                            "root", "password");
//            System.out.println("Database Connected------------");
            return myConn;
        } 
        catch (Exception exp) {
            System.out.println("Database Connection Error -->" 
                    + exp.getMessage());
            return null;
        }
    }
    
    public static void Close ( Connection myConn) {
        try {
            myConn.close();
        } 
        catch (Exception e) {
        }
    }
}
