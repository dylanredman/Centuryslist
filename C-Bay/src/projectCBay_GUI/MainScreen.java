package projectCBay_GUI;

import javax.swing.JFrame;

import projectCBay_code.ProductList;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;

public class MainScreen extends JFrame{
	
	private JRadioButton rdbtnNew = new JRadioButton("New");
	private JRadioButton rdbtnUsed = new JRadioButton("Used");

	public MainScreen(String title, ProductList products) {
		super(title);
		setSize(662, 614);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel sidePanel = new JPanel();
		getContentPane().add(sidePanel, BorderLayout.WEST);
		sidePanel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel searchBarAndStatusPanel = new JPanel();
		sidePanel.add(searchBarAndStatusPanel);
		searchBarAndStatusPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel searchPanel = new JPanel();
		searchBarAndStatusPanel.add(searchPanel);
		
		JTextField searchTxtFld = new JTextField();
		searchPanel.add(searchTxtFld);
		searchTxtFld.setColumns(10);
		
		JButton searchBtn = new JButton("Search");
		searchPanel.add(searchBtn);
		
		JPanel statusPanel = new JPanel();
		searchBarAndStatusPanel.add(statusPanel);
		
	
		statusPanel.add(rdbtnNew);
		rdbtnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnUsed.setSelected(false);
			}
		});
		
		
		statusPanel.add(rdbtnUsed);
		rdbtnUsed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNew.setSelected(false);
			}
		});
		
		
		JPanel filterPanel = new JPanel();
		sidePanel.add(filterPanel);
		filterPanel.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel searchFiltersLbl = new JLabel("Search Filters:");
		filterPanel.add(searchFiltersLbl);
		
		JLabel blankLbl = new JLabel("");
		filterPanel.add(blankLbl);
		
		JRadioButton rdbtnAutomotive = new JRadioButton("Automotive");
		filterPanel.add(rdbtnAutomotive);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Clothing");
		filterPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnElectronics = new JRadioButton("Electronics");
		filterPanel.add(rdbtnElectronics);
		
		JRadioButton rdbtnFurniture = new JRadioButton("Furniture");
		filterPanel.add(rdbtnFurniture);
		
		JRadioButton rdbtnHealth = new JRadioButton("Health");
		filterPanel.add(rdbtnHealth);
		
		JRadioButton rdbtnHomeImprovement = new JRadioButton("Home Improvement");
		filterPanel.add(rdbtnHomeImprovement);
		
		JButton btnClearFilters = new JButton("Clear Filters");
		filterPanel.add(btnClearFilters);
		
		JPanel pricePanel = new JPanel();
		sidePanel.add(pricePanel);
		
		JLabel lblSelectPriceVariation = new JLabel("Select Price Variation:");
		pricePanel.add(lblSelectPriceVariation);
		
		JPanel welcomePanel = new JPanel();
		getContentPane().add(welcomePanel, BorderLayout.NORTH);
		
		JLabel welcomeLbl = new JLabel("Welcome to C-Bay Online Shopping");
		welcomeLbl.setFont(new Font("Lucida Fax", Font.BOLD, 30));
		welcomePanel.add(welcomeLbl);
		
		JPanel displayPanel = new JPanel();
		getContentPane().add(displayPanel, BorderLayout.CENTER);
	}
}
