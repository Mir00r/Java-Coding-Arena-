package com.ConnectJavaSwingGuiToMySql.dao;

import java.awt.List;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ConnectJavaSwingGuiToMySql.core.Employee;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeDAO {
	public static void main(String[] args) throws Exception {	
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.SearchEmployees("thom"));

		System.out.println(dao.GetAllEmployees());
	}
	
	private Connection myConn;
	
	public void AddEmployee ( Employee TheEmployee ) throws Exception {
		PreparedStatement myStmt = null;
		
		try {
			// prepare statement
			myStmt = (PreparedStatement) myConn.prepareStatement("insert into employees"
					+ " (first_name, last_name, email, salary)"
					+ " values (?, ?, ?, ?)");
			
			// set parameter 
			myStmt.setString(1, TheEmployee.getFirstName());
			myStmt.setString(2, TheEmployee.getLastName());
			myStmt.setString(3, TheEmployee.getEmail());
			myStmt.setBigDecimal(4, TheEmployee.getSalary());
			
			// Execute Query 
			myStmt.executeUpdate();
		} 
		finally {
			Close ( myStmt );
		}
	}
	
	public ArrayList < Employee > SearchEmployees ( String lastName) throws Exception {
		ArrayList < Employee > list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			lastName += "%";
			myStmt = (PreparedStatement) myConn.prepareStatement("select * from employeessearch where last_name like ?");
			
			myStmt.setString(1, lastName);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		} 
		finally {
			Close(myStmt, myRs);
		}
	}
	
	public ArrayList< Employee > GetAllEmployees () throws Exception {
		ArrayList< Employee > list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from employeessearch");
			
			while ( myRs.next() ) {
				Employee tmpEmp = convertRowToEmployee(myRs);
				list.add(tmpEmp);
			}
			
			return list;
		} finally {
			Close(myStmt, myRs);
		}
	}
	
	private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {
		
		int id = myRs.getInt("id");
		String lastName = myRs.getString("last_name");
		String firstName = myRs.getString("first_name");
		String email = myRs.getString("email");
		BigDecimal salary = myRs.getBigDecimal("salary");
		
		Employee tempEmployee = new Employee(id, lastName, firstName, email, salary);
		
		return tempEmployee;
	}
	
	private void Close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	
	private void Close(Statement myStmt, ResultSet myRs) throws SQLException {
		Close(null, myStmt, myRs);		
	}
	
	private void Close(Statement myStmt) throws SQLException {
		Close(null, myStmt, null );		
	}
	
 	public EmployeeDAO() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/demo";
			String username = "root";
			String password = "password";
			Class.forName(driver);

			myConn = DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected");
			//return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		//return null;
	}
	
}
