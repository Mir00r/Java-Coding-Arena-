package com.imp;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.imp.dao.DatabaseConnectionHelper;
import com.mysql.jdbc.CallableStatement;

public class ProductController {
	public static boolean SavePname ( String pname ) throws SQLException {
		Connection myConn = null;
		CallableStatement myCsmt = null;
		boolean check = true;
		
		try {
			myConn = DatabaseConnectionHelper.getConnection();
			myCsmt = (CallableStatement) myConn.prepareCall("{ CALL save_product(?) }");
			
			myCsmt.setString(1, pname);
			check = myCsmt.execute();
		} 
		catch (Exception exp) {
			exp.printStackTrace();
		}
		finally{
			Close (myConn, myCsmt);
		}
		return check;
	}
	
	public static boolean SavePurchase ( String pname, String price, String pdate, String qty ) throws SQLException {
		Connection myConn = null;
		CallableStatement myCsmt = null;
		boolean check = true;
		
		try {
			myConn = DatabaseConnectionHelper.getConnection();
			myCsmt = (CallableStatement) myConn.prepareCall("{ CALL save_purchase(getProductid(?), ?, ?, ?) }");
			
			myCsmt.setString(1, pname);
			myCsmt.setString(2, price);
			myCsmt.setString(3, pdate);
			myCsmt.setString(4, qty);
			
			check = myCsmt.execute();
		} 
		catch (Exception exp) {
			exp.printStackTrace();
		}
		finally{
			Close (myConn, myCsmt);
		}
		return check;
	}
	
	public static boolean SaveSale ( String pname, String price, String Sdate, String qty ) throws SQLException {
		Connection myConn = null;
		CallableStatement myCsmt = null;
		boolean check = true;
		
		try {
			myConn = DatabaseConnectionHelper.getConnection();
			myCsmt = (CallableStatement) myConn.prepareCall("{ CALL save_sale(getProductid(?), ?, ?, ?) }");
			
			myCsmt.setString(1, pname);
			myCsmt.setString(2, price);
			myCsmt.setString(3, Sdate);
			myCsmt.setString(4, qty);
			
			check = myCsmt.execute();
		} 
		catch (Exception exp) {
			exp.printStackTrace();
		}
		finally{
			Close (myConn, myCsmt);
		}
		return check;
	}
	
	public static void LoadComboBox ( JComboBox combo ) throws SQLException {
		Connection myConn = null;
		CallableStatement myCsmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = DatabaseConnectionHelper.getConnection();
			myCsmt = (CallableStatement) myConn.prepareCall("{ CALL listProduct() }");
			
			myCsmt.execute();
			myRs = myCsmt.getResultSet();
			
			ArrayList pList = new ArrayList();
			
			while ( myRs.next() ) {
				pList.add(myRs.getString(1));
			}
			
			combo.setModel(new DefaultComboBoxModel(pList.toArray()));
			combo.insertItemAt("Select one", 0);
			combo.setSelectedIndex(0);
		} 
		catch (Exception exp) {
			exp.printStackTrace();
		}
		finally{
			Close (myConn, myCsmt, myRs);
		}
	}
	
	
	private static void Close(Connection myConn, CallableStatement myStmt)
			throws SQLException {

		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	
	private static void Close(Connection myConn, CallableStatement myStmt, ResultSet myRs)
			throws SQLException {

		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
		
		if (myRs != null) {
			myRs.close();
		}
	}
}
