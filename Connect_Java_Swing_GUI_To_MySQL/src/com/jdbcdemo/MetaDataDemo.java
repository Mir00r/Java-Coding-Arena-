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

public class MetaDataDemo {

	public static void main(String[] args) throws Exception {
		//getConnection();
		MetaDataBasicInfo();
	}
	
	public static void MetaDataBasicInfo () throws SQLException {
		Connection myConn = null;
	
		try {
			
			myConn = getConnection();
			
			// Get Metadata
			DatabaseMetaData dbmd = (DatabaseMetaData) myConn.getMetaData();
			
			// Display Info about Database
			
			System.out.println("Product Name -> " + dbmd.getDatabaseProductName());
			System.out.println("Product Version -> " + dbmd.getDatabaseProductVersion());
			System.out.println();
			
			// Display info about JDBC Driver
			System.out.println("JDBC Driver Name -> " + dbmd.getDriverName());
			System.out.println("JDBC Driver version Name -> " + dbmd.getDriverVersion());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Close(myConn);
		}
	}
	
	private static void Close(Connection myConn)
			throws SQLException {

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
