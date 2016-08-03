package com.ConnectJavaSwingGuiToMySql.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.ConnectJavaSwingGuiToMySql.core.Employee;

@SuppressWarnings("serial")
public class EmployeeTableModel extends AbstractTableModel {
	private static final int LAST_NAME_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int EMAIL_COL = 2;
	private static final int SALARY_COL = 3;

	private String[] columnNames = { "Last Name", "First Name", "Email",
	"Salary" };
	private ArrayList <Employee> emp;
	
	public EmployeeTableModel( ArrayList <Employee> theEmployees) {
		emp = theEmployees;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return emp.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		Employee tmpEmp = emp.get(row);
		
		switch (col) {
			case LAST_NAME_COL:
				return tmpEmp.getLastName();
			case FIRST_NAME_COL:
				return tmpEmp.getFirstName();
			case EMAIL_COL:
				return tmpEmp.getEmail();
			case SALARY_COL:
				return tmpEmp.getSalary();
			default:
				return tmpEmp.getLastName();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
