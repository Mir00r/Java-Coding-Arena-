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
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class TransactionsDemo {

	public static void main(String[] args) throws Exception {
		//getConnection();
		Transaction();
	}
	
	public static void Transaction () {
		Connection myConn = null;
		Statement myStmt = null;
		
		try {
			myConn = getConnection();
			
			// Turn off auto Commit
			myConn.setAutoCommit(false);
			
			// Show Salries Before
			System.out.println("Salaries Before.^.^.^.^.^..\n");
			ShowSalaries(myConn, "HR");
			ShowSalaries(myConn, "Engineering");
			
			// Transaction 1: Delete all HR employees
			myStmt = myConn.createStatement();
			myStmt.executeUpdate("delete from employees where department = 'HR'");
			
			// Transaction 2: Set salaries 300000 for all Engineering department employee
			myStmt.executeUpdate("update employees set salary = 300000 where department = 'engineering'");
			System.out.println("\n-> Transaction steps are ready.\n");
			
			boolean check = AskUserIfOkToSave();
			
			if ( check ){
				myConn.commit();
				System.out.println("\n-> Transaction Commited..^^..^^..");
			}
			else {
				myConn.rollback();
				System.out.println("\n-> Transaction Rollback..~~..~~..");
			}
			
			// Show salaries AFTER
			System.out.println("Salaries AFTER\n");
			ShowSalaries(myConn, "HR");
			ShowSalaries(myConn, "Engineering");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ShowSalaries ( Connection conn, String thedepartment  ) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = (PreparedStatement) conn.prepareStatement("select * from employees where department = ?");
			myStmt.setString(1, thedepartment);
			
			myRs = myStmt.executeQuery();
			
			// Process result set
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			Close ( myStmt, myRs);
		}
	}
		
	
	private static boolean AskUserIfOkToSave () {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Is it ok to save? hit yes/no: ");
		String hit = sc.nextLine();
		
		sc.close();
		return hit.equalsIgnoreCase("yes");
	}
	
	private static void Close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
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

	private static void Close(Statement myStmt, ResultSet myRs) throws SQLException {
		Close(null, myStmt, myRs);
	}
	
	private static void Close(Connection myConn, Statement myStmt) throws SQLException {
		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
	
	public static void Display ( ResultSet myRs ) throws SQLException {
		while (myRs.next()) {	
			String lastName = myRs.getString("first_name");
			String firstName = myRs.getString("last_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}
	
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
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
