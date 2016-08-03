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

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;


public class StoredProcedures {

	public static void main(String[] args) throws Exception {
		//getConnection();
		//IncreaseSalariesForDepartment();
		//GreetTheDepartment();
		//GetCountForDepartment();
		GetEmployeeForDepartment();
	}
	
	// Calling MySQL Stored Procedures is "IN"
	public static void GetEmployeeForDepartment() throws Exception {
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		
		try {	
			myConn = getConnection();
			String Department = "Engineering";	
			
			// Prepare the stored procedure call
			myStmt = (CallableStatement) myConn
					.prepareCall("{call get_employees_for_department(?)}");

			// Set the parameters
			myStmt.setString(1, Department);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  get_employees_for_department('" + Department + "') ");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			// Get the result set
			myRs = myStmt.getResultSet();

			// Display the result set
			Display( myRs );
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Close( myConn, myStmt, myRs);
		}
	}
	
	// Calling MySQL Stored Procedures is "IN and OUT"
	public static void GetCountForDepartment() throws Exception {
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		try {	
			myConn = getConnection();
			String Department = "Engineering";	
			
			// Prepare the stored procedure call
			myStmt = (CallableStatement) myConn
					.prepareCall("{call get_count_for_department(?, ?)}");

			// Set the parameters
			myStmt.setString(1, Department);
			myStmt.registerOutParameter(2, Types.INTEGER);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  get_count_for_department('" + Department + "') ");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			// Get the value of the INOUT parameter
			int cnt = myStmt.getInt(2);
			System.out.println("\nThe Count result is = " + cnt);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Close( myConn, myStmt);
		}
	}
	
	// Calling MySQL Stored Procedures is "INOUT"
	public static void GreetTheDepartment() throws Exception {
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		try {	
			myConn = getConnection();
			String Department = "Engineering";	
			
			// Prepare the stored procedure call
			myStmt = (CallableStatement) myConn
					.prepareCall("{call greet_the_department(?)}");

			// Set the parameters
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, Department);
			

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  greet_the_department('" + Department + "') ");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			// Get the value of the INOUT parameter
			String theResult = myStmt.getString(1);
			System.out.println("\nThe result = " + theResult);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Close( myConn, myStmt);
		}
	}
	
	// Calling MySQL Stored Procedures is "IN"
	public static void IncreaseSalariesForDepartment() throws Exception {
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		try {	
			myConn = getConnection();
			String Department = "Engineering";	
			int IncreaseAmount = 10000;
			
			System.out.println("Salaries Without Incresing the Amount..@...");
			ShowSalaries ( myConn, Department );
			
			// Prepare the stored procedure call
			myStmt = (CallableStatement) myConn
					.prepareCall("{call increase_salaries_for_department(?, ?)}");

			// Set the parameters
			myStmt.setString(1, Department);
			myStmt.setDouble(2, IncreaseAmount);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  increase_salaries_for_department('" + Department + "', " + IncreaseAmount + ")");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			// Show salaries AFTER
			System.out.println("\n\nSalaries AFTER Inreasing the Amount........................\n");
			ShowSalaries(myConn, Department);
		} 
		catch (Exception e) {
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
