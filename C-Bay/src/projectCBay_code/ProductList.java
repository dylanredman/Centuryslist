package projectCBay_code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProductList{
	
	private Product[] data = new Product[41];
	private int manyItems;
	
	private static final int DESCRIPTION = 0;
	private static final int STATUS = 1;
	private static final int PRICE = 2;
	private static final int RATING = 3;
	private static final int TYPE = 4;
	private static final int CONTACTINFO = 5;
	private static final int PICTURE = 6;
	
	
	public ProductList() { //Default constructor
		manyItems = 0;
		retrieveList();
	}
	
	public void add(Product element) {
		if(manyItems == data.length) {
			ensureCapacity(manyItems*2 + 1);
		}
		data[manyItems] = element;
		manyItems++;	
	}
	
	public void retrieveList() {
		
		String fileName = "Products.txt";	
		
		try {
			Scanner inFile = new Scanner(new FileInputStream(fileName));

			while (inFile.hasNextLine()) {
				String line = inFile.nextLine();
				String[] ProductProperties = line.split(",");
					
					
				String description = ProductProperties[DESCRIPTION];
				String status = ProductProperties[STATUS];
				Double price = Double.parseDouble(ProductProperties[PRICE]);
				int rating = Integer.parseInt(ProductProperties[RATING]);
				String type = ProductProperties[TYPE];
				String contactInfo = ProductProperties[CONTACTINFO];
				String picture = "picture";
						
				Product product = new Product(description, price, rating,type,contactInfo,status, picture);
				
				add(product);
			}
			inFile.close();	
		} catch (FileNotFoundException e2) {
			System.out.println(fileName + " doesn't exist!");
		}
        
    } 
	
	public void exportNewList(){
		String fileName = "Products.txt";
		
		//clears file
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(new FileOutputStream(fileName, true));
			for (int i = 0; i < manyItems; i++) {
				if(data[i] != null)
					outputFile.println(data[i].toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		outputFile.close();
	}
	

	public boolean remove(Product target) {
		int index;
		index = 0;
		while((index < manyItems) && (target != data[index]))
			index++;
		if(index == manyItems) {
			return false;
		}
		else {
			manyItems--;
			data[index] = data[manyItems];
			return true;
		}
	}
	

	public void ensureCapacity(int i) {
		Product[] biggerArray;
		if(data.length < i) {
			biggerArray = new Product[i];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}
	

	public Product[] search(String target) {
		Product[] p = new Product[manyItems];
		int counter = 0;
		//int i = 0;
		//while(i<=manyItems) {
			for (int i = 0; i < manyItems; i++) {
				if(data[i].getDescription().toLowerCase().equals(target.toLowerCase())) {
					p[counter] = data[i];
					counter++;
					//break;
				}
				data = p;
			}
		//}
		return data;
	}
	
	public Product[] lowerToHigherPriceSort() {
		Product[] p = new Product[manyItems]; 
		p = data;
		//Bubble Sort
        for (int i = 0; i < manyItems; i++) 
            for (int j = 1; j < manyItems-i; j++) 
                if (p[j].getPrice() > p[j+1].getPrice()) 
                { 
                    Product temp = p[j]; 
                    p[j] = p[j+1]; 
                    p[j+1] = temp; 
                } 
        data = p;
		return data;
	}
	
	public Product[] higherToLowerPriceSort() {
		Product[] p = new Product[manyItems]; 
		p = data;
		//Bubble Sort
        for (int i = 0; i < manyItems; i++) 
            for (int j = 1; j < manyItems-i; j++) 
                if (p[j].getPrice() > p[j+1].getPrice()) 
                { 
                    Product temp = p[j-1]; 
                    p[j-1] = p[j]; 
                    p[j] = temp; 
                }
        data = p;
		return data;
	}
 	
	public void listProducts() {
		for (int i = 0; i < manyItems; i++) {
			if(data[i] != null)
				System.out.println(data[i].toString());
		}
	}
	
	public void listProducts(Product[] p) {
		for (int i = 0; i < p.length; i++) {
			if(p[i] != null)
				System.out.println(p[i].toString());
		}
	}
	

}
