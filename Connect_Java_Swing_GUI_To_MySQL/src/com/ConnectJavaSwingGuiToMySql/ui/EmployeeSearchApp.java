package com.ConnectJavaSwingGuiToMySql.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.ConnectJavaSwingGuiToMySql.dao.EmployeeDAO;
import com.ConnectJavaSwingGuiToMySql.core.Employee;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EmployeeSearchApp extends JFrame {

	protected static final EmployeeSearchApp EmployeeSearchApp = null;
	//protected static final EmployeeSearchApp EmployeeSearchApp = null;
	private JPanel contentPane;
	private JTextField lastNametextField;
	private JTable table;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	
	private EmployeeDAO employeeDAO;
	private final JButton btnAddNewEmployee = new JButton("Add New Employee");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeSearchApp frame = new EmployeeSearchApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeSearchApp() {
		// create the DAO
		try {
			employeeDAO = new EmployeeDAO();
		} 
		catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		setTitle("Employee Search App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enter Last Name");
		panel.add(lblNewLabel);
		
		lastNametextField = new JTextField();
		panel.add(lastNametextField);
		lastNametextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actEvn) {

				try {
					// Get last name from the text field
					String lastName = 	lastNametextField.getText();
					ArrayList < Employee > emp = null;
					
					// Call DAO and get employees for the last name
					// If last name is empty, then get all employees
					if (lastName != null && lastName.trim().length() > 0) {
						emp = employeeDAO.SearchEmployees(lastName);
					} 
					else {
						emp = employeeDAO.GetAllEmployees();
					}
					
					// create the model and update the "table"
					EmployeeTableModel model = new EmployeeTableModel(emp);
					
					table.setModel(model);
					

					// Print out employees
					/*for (Employee temp : emp) {
						System.out.println(temp);
					}*/
					
				} 
				catch (Exception exp) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error: " + exp, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		btnAddNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ActEvn) {
				// create dialog
				AddEmployeeDialog dialog = new AddEmployeeDialog(EmployeeSearchApp, employeeDAO);
				//AddEmployeeDialog dialog = new AddEmployeeDialog(EmployeeSearchApp, employeeDAO);
				
				// show dialog
				dialog.setVisible(true);
			}
		});
		panel_1.add(btnAddNewEmployee);
	}
	
	
	public void refreshEmployeesView() {

		try {
			ArrayList<Employee> employees = employeeDAO.GetAllEmployees();

			// create the model and update the "table"
			EmployeeTableModel model = new EmployeeTableModel(employees);

			table.setModel(model);
		} catch (Exception exp) {
			JOptionPane.showMessageDialog(this, "Error: " + exp, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
