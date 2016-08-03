package com.jdbcdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
import java.util.concurrent.ThreadPoolExecutor;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class WrtingCLOBDemo {

	public static void main(String[] args) throws Exception {
		//getConnection();
		WritingCLOB();
	}
	
	@SuppressWarnings("resource")
	public static void WritingCLOB () throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		FileInputStream input = null;
		
		try {
			
			myConn = getConnection();
			
			// Run Query for prepare statement
			String sql = "update employeesclob set resume = ? where email='john.doe@foo.com'";
			myStmt = (PreparedStatement) myConn.prepareStatement(sql);				
			
			// Set parameter for resume file name
			File theFile = new File("sample_resume.txt");
			input = new FileInputStream(theFile);
			myStmt.setBinaryStream(1, input);
			
			System.out.println("Reading Input file....*****......" + theFile.getAbsolutePath());
			
			// Execute Statement
			System.out.println("\nStoring resume in Database...." + theFile);
			System.out.println(sql);
			
			myStmt.executeUpdate();
			
			System.out.println("\nStoring Reusme successfully!.....|||..........");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Close(myConn, myStmt );
		}
	}
	
	private static void Close(Connection myConn, Statement myStmt)
			throws SQLException {

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
