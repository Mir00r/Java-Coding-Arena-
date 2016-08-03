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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class Driver {

	//private static final String DateFormat = null;

	public static void main(String[] args) throws Exception {
		//getConnection();
		CreateTable();
		//PostData();
		//GetData();
		//UpdateData();
		//DeleteData();
		//DropTable();
		//PrepareStmt();
	}
	
	// Prepared Statements Example
	public static void PrepareStmt() throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = getConnection();
			
			// 2. Prepare statement
			myStmt = (PreparedStatement) myConn.prepareStatement("select * from employees where salary > ? and department=?");
			
			// 3. Set the parameters
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			// 4. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 5. Display the result set
			Display(myRs);
		
			//
			// Reuse the prepared statement:  salary > 25000,  department = HR
			//

			System.out.println("\n\nReuse the prepared statement:  salary > 25000,  department = HR");
			
			// 6. Set the parameters
			myStmt.setDouble(1, 25000);
			myStmt.setString(2, "HR");
			
			// 7. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 8. Display the result set
			Display(myRs);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
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
	
	public static void DropTable() throws Exception {
		
		Connection conn = getConnection();

		try {
			Statement posted = (Statement) conn.createStatement();
			String Dsql = "drop table employees";
			
			posted.executeUpdate(Dsql);
			
		} catch (Exception exp) {
			System.out.println(exp);
		} finally {
			System.out.println("Drop Table Successfully !!....");
		}
	}
	
	public static void DeleteData() throws Exception {
		
		Connection conn = getConnection();

		try {
			Statement posted = (Statement) conn.createStatement();
			String Dsql = "delete from employees where Last_Name = 'Smith'";
			
			int RowsAffected =  posted.executeUpdate(Dsql);
			
			System.out.println("Rows Affected: " +RowsAffected);
		} catch (Exception exp) {
			System.out.println(exp);
		} finally {
			System.out.println("Delete Completed Successfully !!....");
		}
	}
	
	public static void UpdateData() throws Exception {
		
		Connection conn = getConnection();

		try {
			Statement posted = (Statement) conn.createStatement();
			String Usql = "update employees " 
						+ " set Email = 'razzak.cse65@yehoo.com' " 
						+ " where id = 1";
			
			posted.executeUpdate(Usql);
			
		} catch (Exception exp) {
			System.out.println(exp);
		} finally {
			System.out.println("Update Completed Successfully !!....");
		}
	}
	
	public static ArrayList<String> GetData() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement statm = (PreparedStatement) conn.prepareStatement("SELECT * FROM employees ");

			ResultSet result = statm.executeQuery();
			ArrayList<String> arr = new ArrayList<>();

			while (result.next()) {
				System.out.print(result.getString("first_name"));
				System.out.print(" ");
				System.out.print(result.getString("last_name"));
				System.out.print(" ");
				System.out.println(result.getString("email"));

				//arr.add(result.getString("last_name"));
			}
			System.out.println("All record have been selected");
			return arr;
		} 
		catch (Exception exp) {
			System.out.println(exp);
		}
		return null;
	}
	
	public static void PostData() throws Exception {
		final String first_name, last_name, email;
		first_name = "David";
		last_name = "Gilmour";
		email = "david.gilmour@gmail.com";
		

		Connection conn = getConnection();

		try {
			PreparedStatement posted = (PreparedStatement) conn
					.prepareStatement("INSERT INTO employees (first_name, last_name, email) VALUES ('" + first_name
							+ "', '" + last_name + "', '" + email + "' ) ");
			posted.executeUpdate();
		} catch (Exception exp) {
			System.out.println(exp);
		} finally {
			System.out.println("Insert Completed Successfully !!....");
		}
	}
	
	public static void CreateTable() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = (PreparedStatement) conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS employees(id int NOT NULL AUTO_INCREMENT, "
					+ "last_name varchar(255), first_name varchar(255), email varchar(255), "
					+ "department varchar(64), salary decimal(10, 2), resume BLOB, PRIMARY KEY(id) )");
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Table Create Successfully........");
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
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}