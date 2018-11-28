package projectCBay_GUI;

import javax.swing.JFrame;

import projectCBay_code.CartStack;
import projectCBay_code.Product;
import projectCBay_code.ProductList;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class MainScreen extends JFrame{
	
	private ProductList p = new ProductList();
	private int num = p.getNumOfItems();
	private CartStack c = new CartStack();
	
	private JRadioButton rdbtnNew = new JRadioButton("New");
	private JRadioButton rdbtnUsed = new JRadioButton("Used");
	private JRadioButton rdbtnAutomotive = new JRadioButton("Automotive");
	private JRadioButton rdbtnClothing = new JRadioButton("Clothing"); 
	private JRadioButton rdbtnElectronics = new JRadioButton("Electronics");
	private JRadioButton rdbtnFurniture = new JRadioButton("Furniture");
	private JRadioButton rdbtnHealth = new JRadioButton("Health");
	private JRadioButton rdbtnHomeImprovement = new JRadioButton("Home Improvement");
	private JRadioButton radioButtonHighestToLowest = new JRadioButton("Highest to Lowest");
	private JRadioButton radioButtonLowestToHighest = new JRadioButton("Lowest to Highest");
	
	private JButton btnClearFilters = new JButton("Clear Filters");
	private JButton addProductBtn = new JButton("Add Product");
	private JButton searchBtn = new JButton("Search");
	private JButton addToCartBtn = new JButton("Add to Cart");
	
	private JPanel displayPanel = new JPanel();
	private JPanel welcomePanel = new JPanel();
	private JPanel pricePanel = new JPanel();
	private JPanel addProductPanel = new JPanel();
	private JPanel sidePanel = new JPanel();
	private JPanel searchBarAndStatusPanel = new JPanel();
	private JPanel searchPanel = new JPanel();
	private JPanel statusPanel = new JPanel();
	private JPanel filterPanel = new JPanel();
	
	private JLabel searchFiltersLbl = new JLabel("Search Filters:");
	private JLabel lblSelectPriceVariation = new JLabel("Select Price Variation:");
	private JLabel welcomeLbl = new JLabel("Welcome to C-Bay Online Shopping");
	
	private JTextField searchTxtFld = new JTextField();
	private JList shoppingList = new JList();
	private JPanel addToCartPanel = new JPanel();

	
	private JScrollPane scrollPane = new JScrollPane();
	private JList cartList = new JList();
	private JScrollPane scrollPane2 = new JScrollPane();
	private DefaultListModel<Product> catalog = new DefaultListModel();
	private DefaultListModel<Product> cart = new DefaultListModel();
	


	public MainScreen(String title, ProductList products) {
		super(title);
		setSize(2400, 1200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(sidePanel, BorderLayout.WEST);
		getContentPane().add(welcomePanel, BorderLayout.NORTH);
		getContentPane().add(displayPanel, BorderLayout.CENTER);
		resetShoppingMenu();
		setContents();
		addActionListeners();		
	}
	
	
	public void setContents() {
		sidePanel.setLayout(new GridLayout(4, 1, 0, 0));
		sidePanel.add(searchBarAndStatusPanel);
		sidePanel.add(filterPanel);
		sidePanel.add(pricePanel);
		sidePanel.add(addProductPanel);
		
		displayPanel.setLayout(new GridLayout(1, 3, 0, 0));
		displayPanel.add(scrollPane);
		displayPanel.add(addToCartPanel);
		displayPanel.add(scrollPane2);
		
		searchBarAndStatusPanel.setLayout(new GridLayout(2, 1, 0, 0));
		searchBarAndStatusPanel.add(searchPanel);
		searchBarAndStatusPanel.add(statusPanel);
		searchTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		searchPanel.add(searchTxtFld);
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		searchPanel.add(searchBtn);
		
		searchTxtFld.setColumns(10);
		rdbtnNew.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		statusPanel.add(rdbtnNew);
		rdbtnUsed.setFont(new Font("Tahoma", Font.PLAIN, 24));
		statusPanel.add(rdbtnUsed);
		
		filterPanel.setLayout(new GridLayout(5, 2, 0, 0));
		searchFiltersLbl.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filterPanel.add(searchFiltersLbl);
		rdbtnAutomotive.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filterPanel.add(rdbtnAutomotive);
		rdbtnClothing.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filterPanel.add(rdbtnClothing);
		rdbtnElectronics.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filterPanel.add(rdbtnElectronics);
		rdbtnFurniture.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filterPanel.add(rdbtnFurniture);
		rdbtnHealth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filterPanel.add(rdbtnHealth);	
		rdbtnHomeImprovement.setFont(new Font("Tahoma", Font.PLAIN, 24));
		filterPanel.add(rdbtnHomeImprovement);
		
		pricePanel.setLayout(new GridLayout(5, 1, 0, 0));
		lblSelectPriceVariation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pricePanel.add(lblSelectPriceVariation);
		radioButtonHighestToLowest.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pricePanel.add(radioButtonHighestToLowest);
		radioButtonLowestToHighest.setFont(new Font("Tahoma", Font.PLAIN, 24));
		pricePanel.add(radioButtonLowestToHighest);
		
		addProductPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnClearFilters.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addProductPanel.add(btnClearFilters);
		addProductBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addProductPanel.add(addProductBtn);
		
		welcomeLbl.setFont(new Font("Lucida Fax", Font.BOLD, 30));
		welcomePanel.add(welcomeLbl);
		
		shoppingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shoppingList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		addToCartPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		addToCartPanel.add(addToCartBtn);
		
		cartList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
		
	public void resetShoppingMenu() {
		this.catalog.clear();
		for (int i = 0; i < num; i++) {
			this.catalog.addElement(p.product(i));
		}
		shoppingList = new JList<>(catalog);
		scrollPane = new JScrollPane(shoppingList);
	}
	
	public void addActionListeners() {
		rdbtnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shoppingList = new JList<>(p.newProducts());
				rdbtnUsed.setEnabled(false);
				rdbtnNew.setEnabled(false);
			}
		});
		
		rdbtnUsed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shoppingList = new JList<>(p.usedProducts());
				rdbtnUsed.setEnabled(false);
				rdbtnNew.setEnabled(false);
			}
		});
		
		rdbtnAutomotive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnElectronics.setEnabled(false);
				rdbtnAutomotive.setEnabled(false);
				rdbtnClothing.setEnabled(false);
				rdbtnHealth.setEnabled(false);
				rdbtnFurniture.setEnabled(false);
				rdbtnHomeImprovement.setEnabled(false);
			}
		});
		
		rdbtnClothing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnElectronics.setEnabled(false);
				rdbtnAutomotive.setEnabled(false);
				rdbtnClothing.setEnabled(false);
				rdbtnHealth.setEnabled(false);
				rdbtnFurniture.setEnabled(false);
				rdbtnHomeImprovement.setEnabled(false);
			}
		});
		
		rdbtnElectronics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnElectronics.setEnabled(false);
				rdbtnAutomotive.setEnabled(false);
				rdbtnClothing.setEnabled(false);
				rdbtnHealth.setEnabled(false);
				rdbtnFurniture.setEnabled(false);
				rdbtnHomeImprovement.setEnabled(false);
			}
		});
		
		rdbtnHealth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnElectronics.setEnabled(false);
				rdbtnAutomotive.setEnabled(false);
				rdbtnClothing.setEnabled(false);
				rdbtnHealth.setEnabled(false);
				rdbtnFurniture.setEnabled(false);
				rdbtnHomeImprovement.setEnabled(false);
			}
		});
		
		rdbtnFurniture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnElectronics.setEnabled(false);
				rdbtnAutomotive.setEnabled(false);
				rdbtnClothing.setEnabled(false);
				rdbtnHealth.setEnabled(false);
				rdbtnFurniture.setEnabled(false);
				rdbtnHomeImprovement.setEnabled(false);
			}
		});
		
		rdbtnHomeImprovement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				rdbtnElectronics.setEnabled(false);
				rdbtnAutomotive.setEnabled(false);
				rdbtnClothing.setEnabled(false);
				rdbtnHealth.setEnabled(false);
				rdbtnFurniture.setEnabled(false);
				rdbtnHomeImprovement.setEnabled(false);
			}
		});
		
		radioButtonHighestToLowest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shoppingList = new JList<>(p.higherToLowerPriceSort());
				radioButtonHighestToLowest.setEnabled(false);
				radioButtonLowestToHighest.setEnabled(false);
			}
		});
		
		radioButtonLowestToHighest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shoppingList = new JList<>(p.lowerToHigherPriceSort());
				radioButtonHighestToLowest.setEnabled(false);
				radioButtonLowestToHighest.setEnabled(false);
			}
		});

		btnClearFilters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p.clearFilters();
				rdbtnUsed.setEnabled(true);
				rdbtnNew.setEnabled(true);
				rdbtnUsed.setSelected(false);
				rdbtnNew.setSelected(false);
				radioButtonHighestToLowest.setEnabled(true);
				radioButtonLowestToHighest.setEnabled(true);
				rdbtnElectronics.setEnabled(true);
				rdbtnAutomotive.setEnabled(true);
				rdbtnClothing.setEnabled(true);
				rdbtnHealth.setEnabled(true);
				rdbtnFurniture.setEnabled(true);
				rdbtnHomeImprovement.setEnabled(true);
				radioButtonHighestToLowest.setSelected(false);
				radioButtonLowestToHighest.setSelected(false);
				rdbtnElectronics.setSelected(false);
				rdbtnAutomotive.setSelected(false);
				rdbtnClothing.setSelected(false);
				rdbtnHealth.setSelected(false);
				rdbtnFurniture.setSelected(false);
				rdbtnHomeImprovement.setSelected(false);
			}
		});	
		
		addToCartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(shoppingList.isSelectionEmpty() == false) {
					cart.addElement((Product) shoppingList.getSelectedValue());
					c.addProductToCart((Product) shoppingList.getSelectedValue());
					setContents();
				}
				else if(shoppingList.isSelectionEmpty() == false)
					JOptionPane.showMessageDialog(null, "Nothing Selected");
				
			}
		});
	}
}