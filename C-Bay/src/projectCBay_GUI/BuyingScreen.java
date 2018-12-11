package projectCBay_GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import projectCBay_code.ProductList;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyingScreen extends JFrame{
	
	private ProductList p = new ProductList();
	
	private JTextField costTxtFld;
	private JTextField userNameTxtFld;
	private JTextField passwordTxtFld;
	
	private double total;
	
	public BuyingScreen(double cost, ProductList products) {
		super("Checkout");
		setSize(1000, 300);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.total = cost;
		p = products;
		
		JPanel displayPanel = new JPanel();
		getContentPane().add(displayPanel, BorderLayout.CENTER);
		displayPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel costPanel = new JPanel();
		displayPanel.add(costPanel, BorderLayout.CENTER);
		costPanel.setVisible(false);
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		costPanel.add(lblTotalCost);
		lblTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		costTxtFld = new JTextField();
		costPanel.add(costTxtFld);
		costTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 24));
		costTxtFld.setEditable(false);
		costTxtFld.setColumns(10);
		costTxtFld.setText("$" + total);
		
		JButton buyBtn = new JButton("Buy");
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Thank you for your purchase! The transaction has gone through successfully!");
				p.exportNewList();
				userNameTxtFld.setText("");
				passwordTxtFld.setText("");
				total = 0;
				setVisible(false);
			}
		});
		costPanel.add(buyBtn);
		buyBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JPanel signInAccountPanel = new JPanel();
		displayPanel.add(signInAccountPanel, BorderLayout.NORTH);
		
		JLabel signInLbl = new JLabel("PayPal Login:");
		signInLbl.setForeground(Color.BLACK);
		signInLbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		signInAccountPanel.add(signInLbl);
		
		userNameTxtFld = new JTextField();
		userNameTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 24));
		signInAccountPanel.add(userNameTxtFld);
		userNameTxtFld.setColumns(10);
		
		JLabel lblPassword = new JLabel("      Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		signInAccountPanel.add(lblPassword);
		
		passwordTxtFld = new JTextField();
		passwordTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 24));
		signInAccountPanel.add(passwordTxtFld);
		passwordTxtFld.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				costPanel.setVisible(true);
			}
		});
		signInAccountPanel.add(btnSignIn);
	}
	
	

}
