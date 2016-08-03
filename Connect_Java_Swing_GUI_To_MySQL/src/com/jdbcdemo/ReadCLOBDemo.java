package com.jdbcdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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

public class ReadCLOBDemo {

	public static void main(String[] args) throws Exception {
		//getConnection();
		ReadCLOB();
	}
	
	@SuppressWarnings("resource")
	public static void ReadCLOB () throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		InputStream input = null;
		FileOutputStream output = null;
		
		try {
			
			myConn = getConnection();
			
			// Run Query 
			myStmt = myConn.createStatement();
			String sql = "select resume from employeesclob where email='john.doe@foo.com'";
			myRs = myStmt.executeQuery(sql);				
			
			// Set up handle to the file
			File theFile = new File("resume_from_db.txt");
			output = new FileOutputStream(theFile);
			
			while (myRs.next()) {
				input = myRs.getBinaryStream("resume");
				System.out.println("Reading the Resume from Database..........");
				System.out.println(sql);
				
				int theChar;
				while ((theChar = input.read()) > 0) {
					output.write(theChar);
				}
				
				System.out.println("\nSaved to file "+ theFile.getAbsolutePath());
				System.out.println("File save SuccessFully.....****.....");	
			}
		}
		catch (Exception e) {
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
