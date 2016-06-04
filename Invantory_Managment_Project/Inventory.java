package com.imp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.CallableStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.imp.dao.DatabaseConnectionHelper;
public class Inventory extends JFrame {

	private JPanel contentPane;
	private JTextField PriceTextField;
	private JTextField QtyTextField;
	private JTextField DateTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Inventory() throws SQLException {
		setTitle("Inventory Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblProductName = new JLabel("Product Name:");
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setEditable(true);
		
		JLabel lblNewLabel = new JLabel("Available Quantity:");
		
		JLabel lblNewLabel_1 = new JLabel("AVG Purchase Price:");
		
		JLabel lblNewLabel_2 = new JLabel("Price:");
		
		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		
		JLabel lblNewLabel_4 = new JLabel("Date:");
		
		JLabel lbQty = new JLabel("");
		
		JLabel lbPrice = new JLabel("");
		
		PriceTextField = new JTextField();
		PriceTextField.setColumns(10);
		
		QtyTextField = new JTextField();
		QtyTextField.setColumns(10);
		
		DateTextField = new JTextField();
		DateTextField.setColumns(10);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = false;
				
				if ( comboBox.getSelectedIndex() < 0 ){
					try {
						ProductController.SavePname(comboBox.getSelectedItem().toString());
					} 
					catch (SQLException e) {	
						e.printStackTrace();
					}
				}
				
				try {
					check = ProductController.SavePurchase(comboBox.getSelectedItem().toString(), 
							PriceTextField.getText(), DateTextField.getText(), QtyTextField.getText());
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				
				if (!check){
					JOptionPane.showMessageDialog(rootPane, "Purchase Save SuccessFully.....!!....");
					// By this method we can load all product from our database
					try {
						ProductController.LoadComboBox(comboBox);
						Clear();
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			private void Clear() {
				comboBox.setSelectedIndex(0);
				lbQty.setText("");
				lbPrice.setText("");
				PriceTextField.setText("");
				QtyTextField.setText("");
				DateTextField.setText("");
			}
		});
		
		JButton btnSale = new JButton("Sale");
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean check = false;
				
				if ( comboBox.getSelectedIndex() < 0 ){
					try {
						ProductController.SavePname(comboBox.getSelectedItem().toString());
					} 
					catch (SQLException e) {	
						e.printStackTrace();
					}
				}
				
				try {
					check = ProductController.SaveSale(comboBox.getSelectedItem().toString(), 
							PriceTextField.getText(), DateTextField.getText(), QtyTextField.getText());
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				
				if (!check){
					JOptionPane.showMessageDialog(rootPane, "Sale Save SuccessFully.....!!....");
					// By this method we can load all product from our database
					try {
						ProductController.LoadComboBox(comboBox);
						Clear();
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			private void Clear() {
				comboBox.setSelectedIndex(0);
				lbQty.setText("");
				lbPrice.setText("");
				PriceTextField.setText("");
				QtyTextField.setText("");
				DateTextField.setText("");
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			@SuppressWarnings({ "null", "resource" })
			public void itemStateChanged(ItemEvent arg0) {
				if ( comboBox.getSelectedIndex() > 0 ) {
					Connection myConn = null;
					CallableStatement myCsmt = null;
					ResultSet myRs = null;
					
					try {
						myConn = DatabaseConnectionHelper.getConnection();
						myCsmt = (CallableStatement) myConn.prepareCall("{?= call getProductQty(?)}");
						
						myCsmt.registerOutParameter(1, java.sql.Types.INTEGER);
						myCsmt.setString(2, comboBox.getSelectedItem().toString());
						
						myCsmt.execute();
						
						int output = myCsmt.getInt(1);
						//JLabel lbQty = null;
						//JLabel lbPrice = null;
						
						lbQty.setText(String.valueOf(output));
						
						//
						myCsmt = (CallableStatement) myConn.prepareCall("{CALL avg_price(getProductid(?))}");
						myCsmt.setString(1, comboBox.getSelectedItem().toString());
						myCsmt.execute();
						
						myRs = myCsmt.getResultSet();
						
						while ( myRs.next() ) {
							lbPrice.setText(myRs.getString(1));
						}
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
					finally{
						try {
							myConn.close();
							myCsmt.close();
							myRs.close();
						} 
						catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			
			}
		});
		
		
		JButton btnClear = new JButton("Clear");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblProductName)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(btnPurchase))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbPrice, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addComponent(lbQty, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addComponent(DateTextField, 241, 241, 241)
						.addComponent(QtyTextField, 241, 241, 241)
						.addComponent(PriceTextField, 241, 241, 241)
						.addComponent(comboBox, 0, 241, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(btnSale)
							.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
							.addComponent(btnClear)))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductName)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lbQty, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lbPrice, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(PriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(QtyTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addComponent(DateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPurchase)
						.addComponent(btnClear)
						.addComponent(btnSale))
					.addGap(48))
		);
		contentPane.setLayout(gl_contentPane);
		
		// By this method we can load all product from our database
		ProductController.LoadComboBox(comboBox);
	}
}
