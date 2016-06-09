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
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapp", "root", "password");
            return myConn;
        } 
        catch (Exception exp) {
            System.out.println("Database not Connected" + exp.getMessage());
            return null;
        }
    }
    
    public static void Close( Connection conn){
        try {
            conn.close();
        } 
        catch (Exception e) {
        }
    }
}
