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

public class MetaDataSchemaDemo {

	public static void main(String[] args) throws Exception {
		//getConnection();
		SchemaInfo();
	}
	
	@SuppressWarnings("resource")
	public static void SchemaInfo () throws SQLException {
		Connection myConn = null;
		ResultSet myRs = null;
		
		String Catalog = null;
		String SchemaPattern = null;
		String TableNamePattern = null;
		String ColumnNamePattern = null;
		String[] Types = null;
		
		try {
			
			myConn = getConnection();
			
			// Get Metadata
			DatabaseMetaData dbmd = (DatabaseMetaData) myConn.getMetaData();
			
			// Get List of Table
			
			System.out.println("List of Table");
			System.out.println("----------------------");
			System.out.println();
			
			myRs = dbmd.getTables(Catalog, SchemaPattern, TableNamePattern, Types);
			
			while (myRs.next()) {
				System.out.println(myRs.getString("TABLE_NAME"));
			}
			
			// 4. Get list of columns
			System.out.println("\n\nList of Columns");
			System.out.println("--------------");
			
			myRs = dbmd.getColumns(Catalog, SchemaPattern, "employees", ColumnNamePattern);
			
			while (myRs.next()) {
				System.out.println(myRs.getString("COLUMN_NAME"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Close(myConn, myRs);
		}
	}
	
	private static void Close(Connection myConn, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myConn != null) {
			myConn.close();
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
