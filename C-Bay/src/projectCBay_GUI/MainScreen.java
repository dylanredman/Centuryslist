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
import java.awt.Color;
import javax.swing.SwingConstants;

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
	
	private final JPanel otherSortFilters = new JPanel();
	private final JRadioButton rdbtnSortAlphabetically = new JRadioButton("Sort Alphabetically");
	private final JRadioButton rdbtnHighlyRated = new JRadioButton("Sort By Rating(Lowest to Highest)");
	private final JPanel totalCostPanel = new JPanel();
	private final JButton btnCheckout = new JButton("Checkout");
	private final JPanel checkoutBtnpanel = new JPanel();
	private final JButton btnRemoveFromCart = new JButton("Remove From Cart");
	


	public MainScreen(String title, ProductList products) {
		super(title);
		setSize(2400, 1200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpShoppingMenu();
		setContents();
		addActionListeners();		
	}
	
	
	public void setContents() {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(sidePanel, BorderLayout.WEST);
		getContentPane().add(welcomePanel, BorderLayout.NORTH);
		getContentPane().add(displayPanel, BorderLayout.CENTER);
		getContentPane().add(totalCostPanel, BorderLayout.EAST);
		
		sidePanel.setLayout(new GridLayout(5, 1, 0, 0));
		sidePanel.add(searchBarAndStatusPanel);
		sidePanel.add(filterPanel);
		sidePanel.add(pricePanel);
		
		sidePanel.add(otherSortFilters);
		otherSortFilters.setLayout(new GridLayout(2, 1, 0, 0));
		rdbtnSortAlphabetically.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		otherSortFilters.add(rdbtnSortAlphabetically);
		rdbtnHighlyRated.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		otherSortFilters.add(rdbtnHighlyRated);
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
		
		welcomeLbl.setFont(new Font("Lucida Fax", Font.BOLD, 30));
		welcomePanel.add(welcomeLbl);
		
		shoppingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shoppingList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		addToCartPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		addToCartPanel.add(addToCartBtn);
		
		
		addToCartPanel.add(btnRemoveFromCart);
		
		cartList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		totalCostPanel.setLayout(new GridLayout(6, 2, 0, 0));
		
		totalCostPanel.add(checkoutBtnpanel);
		checkoutBtnpanel.add(btnCheckout);
	}
		
	public void setUpShoppingMenu() {
		this.catalog.clear();
		for (int i = 0; i < num; i++) {
			if(p.setUpMenuProducts(i) == null) {
			}
			else
				this.catalog.addElement(p.setUpMenuProducts(i));
		}
		shoppingList = new JList<>(catalog);
		scrollPane = new JScrollPane(shoppingList);
		cartList = new JList<>(cart);
		cartList.setForeground(Color.BLACK);
		cartList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane2 = new JScrollPane(cartList);
	}
	
	public void addActionListeners() {
		rdbtnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnUsed.setEnabled(false);
				rdbtnNew.setEnabled(false);
				Product[] temp = p.conditionProducts("new");
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
			}
		});
		
		rdbtnUsed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnUsed.setEnabled(false);
				rdbtnNew.setEnabled(false);
				Product[] temp = p.conditionProducts("used");
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
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
				Product[] temp = p.typeSearch("Automotive");
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
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
				Product[] temp = p.typeSearch("Clothing");
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
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
				Product[] temp = p.typeSearch("Electronics");
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
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
				Product[] temp = p.typeSearch("Health");
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
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
				Product[] temp = p.typeSearch("Furniture");
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
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
				Product[] temp = p.typeSearch("Home Improvement");
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
			}
		});
		
		radioButtonHighestToLowest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radioButtonHighestToLowest.setEnabled(false);
				radioButtonLowestToHighest.setEnabled(false);
				Product[] temp = p.higherToLowerPriceSort();
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
			}
		});
		
		radioButtonLowestToHighest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product[] temp = p.lowerToHigherPriceSort();
				radioButtonHighestToLowest.setEnabled(false);
				radioButtonLowestToHighest.setEnabled(false);
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}	
			}
		});

		btnClearFilters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p.clearFilters();
				for (int i = 0; i < cart.getSize(); i++) {
					p.remove(cart.getElementAt(i));
				}
				Product[] temp = p.products();
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
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
				rdbtnHighlyRated.setEnabled(true);
				rdbtnSortAlphabetically.setEnabled(true);
				radioButtonHighestToLowest.setSelected(false);
				radioButtonLowestToHighest.setSelected(false);
				rdbtnElectronics.setSelected(false);
				rdbtnAutomotive.setSelected(false);
				rdbtnClothing.setSelected(false);
				rdbtnHealth.setSelected(false);
				rdbtnFurniture.setSelected(false);
				rdbtnHomeImprovement.setSelected(false);
				rdbtnHighlyRated.setSelected(false);
				rdbtnSortAlphabetically.setSelected(false);
			}
		});	
		
		addToCartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(shoppingList.isSelectionEmpty() == false) {
					Product products = (Product) shoppingList.getSelectedValue();
					cart.addElement(products);
					c.addProductToCart(products);
					p.remove(products);
					catalog.removeElement(products);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Nothing Selected");
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product[] temp = p.search(searchTxtFld.getText());
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
				
			}
		});
		
		rdbtnHighlyRated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product[] temp = p.highlyRatedSearch();
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
				rdbtnHighlyRated.setEnabled(false);
				rdbtnSortAlphabetically.setEnabled(false);
			}
		});
		
		rdbtnSortAlphabetically.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product[] temp = p.sortAlphabet();
				catalog.clear();
				for (int i = 0; i < temp.length; i++) {
					if(temp[i] == null) {
					}
					else
						catalog.addElement(temp[i]);
				}
				rdbtnSortAlphabetically.setEnabled(false);
				rdbtnHighlyRated.setEnabled(false);
			}
		});
		
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog
						(null, "Are you done shopping and want to continue to your cart?","Yes",JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
				double total = c.totalCost();
				BuyingScreen buy = new BuyingScreen(total, p);
				buy.setVisible(true);
				cart.clear();
				}
			}
		});
		
		btnRemoveFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cartList.isSelectionEmpty() == false) {
					Product product = (Product) cartList.getSelectedValue();
					cart.removeElement(product);
					p.add(product);
					c.remove(product);
				}
				else
					JOptionPane.showMessageDialog(null, "Nothing Selected");
			}
			
		});
		
	}
}