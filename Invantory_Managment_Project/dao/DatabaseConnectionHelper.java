package com.imp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionHelper {
	public static void main(String[] args) throws Exception {
		getConnection();
		
	}
	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/imp";
			String username = "root";
			String password = "password";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected");
			return conn;
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
