package com.jdbcdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class MetaDataResultSet {

	public static void main(String[] args) throws Exception {
		getConnection();
		//ResultSetDemo();
	}
	
	@SuppressWarnings("resource")
	public static void ResultSetDemo () throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			myConn = getConnection();
			
			// Run Query 
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select id, last_name, first_name, salary from employees");
			
			// Get result set metadata
			ResultSetMetaData rsmd = (ResultSetMetaData) myRs.getMetaData();
			
			// Display Info 
			int Columncnt = rsmd.getColumnCount();
			
			for ( int i = 1; i <= Columncnt; i++ ) {
				System.out.println("Column name: " + rsmd.getColumnName(Columncnt));
				System.out.println("Column type name: " + rsmd.getColumnTypeName(Columncnt));
				System.out.println("Is Nullable: " + rsmd.isNullable(Columncnt));
				System.out.println("Is Auto Increment: " + rsmd.isAutoIncrement(Columncnt) + "\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Close(myConn, myStmt, myRs);
		}
	}
	
	private static void Close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/demo";
			String username = "root";
			String password = "password";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}	
