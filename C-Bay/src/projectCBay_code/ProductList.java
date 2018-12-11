package projectCBay_code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProductList{
	
	private Product[] data = new Product[40];
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
	
	public int getNumOfItems() {
		return manyItems;
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
					outputFile.println(data[i].list());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		outputFile.close();
	}
	

	public void remove(Product target) {
		for (int i = 0; i < data.length; i++) {
			if(data[i] != null && target.getDescription() != null) {
				if(data[i].getDescription().equals(target.getDescription())) {
					data[i] = data[manyItems - 1];
					manyItems--;
					}
				}
			}
		
		
		/*int index;
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
		}*/
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
				if(data[i] == null) {
					
				}
				else if(data[i].getDescription().toLowerCase().equals(target.toLowerCase())) {
					p[counter] = data[i];
					counter++;
					//break;
				}
			}
			data = p;
			manyItems = data.length;
		//}
		return data;
	}
	
	public Product[] lowerToHigherPriceSort() {
		Product[] p = new Product[manyItems]; 
		
		p = data;
		//Bubble Sort
        for (int i = 0; i < manyItems; i++) {
            for (int j = 1; j < manyItems-i; j++) {
            	if(p[j-1] == null || p[j] == null) {
            	}
            	else if (p[j-1].getPrice() > p[j].getPrice()) 
                { 
                    Product temp = p[j-1]; 
                    p[j-1] = p[j]; 
                    p[j] = temp; 
                }
            }
        }
        this.data = p;
		return data;
	}
	
	public Product[] higherToLowerPriceSort() {
		Product[] p = new Product[manyItems]; 
		p = data;
		//Bubble Sort
        for (int i = 0; i < manyItems; i++) {
            for (int j = 1; j < manyItems-i; j++) {
            	if(p[j-1] == null || p[j] == null) {
            	}
            	else if (p[j-1].getPrice() < p[j].getPrice()) 
                { 
                    Product temp = p[j-1]; 
                    p[j-1] = p[j]; 
                    p[j] = temp; 
                }
            }
        }
	
        this.data = p;
		return data;
	}
	
	public Product[] conditionProducts(String ans) {
		Product[] p = new Product[manyItems]; 
		int count = 0;
		if(ans.equals("new")) {
			for (int i = 0; i < manyItems; i++) {
				if(data[i] == null) {
				}
				else if (data[i].getStatus().equals("new")) 
				{
					p[count] = data[i];
					count++;
				}
			}
		}
		else if(ans.equals("used")) {
			for (int i = 0; i < manyItems; i++) {
				if(data[i] == null) {
				}
				else if (data[i].getStatus().equals("used")) 
				{
					p[count] = data[i];
					count++;
				}
			}
		}
        this.data = p;
        manyItems = data.length;
		return data;
	}
	
	
	public Product[] highlyRatedSearch() {
		int n = manyItems; 
        // Selection sort
        for (int i = 0; i < n-1; i++) 
        {  
            int min = i; 
            for (int j = i+1; j < n; j++) 
            	if(data[j] == null) {
            	}
            	else if (data[j].getRating() < data[min].getRating()) 
                    min = j; 
            Product temp = data[min]; 
            data[min]= data[i]; 
            data[i] = temp; 
        } 
		return data;
	}
	
	public Product[] typeSearch(String type) {
		// Returns a new array with only items of the given type.
		Product[] p =  new Product[manyItems];
		Product[] newP =  new Product[manyItems];
		p = data;
		int n = 0;
		int x = 0;
		while(n < manyItems) {
			if(p[n] == null) {
			}
			else if (p[n].getType().equals(type)){
				newP[x] = p[n];
				x++;
			}
			n++;
		}
		return data = newP;
	}
	
	 public Product[] sortAlphabet() {
		 Product[] x = new Product[manyItems];
		 x = data;
		 int j;
         boolean flag = true; 
         Product temp;

         while ( flag )
         {
        	 flag = false;
             for ( j = 0;  j < x.length - 1;  j++ )
             {
            	 if(x[j+1] == null) {	 
            	 }
            	 else if(x[j].compareTo(x[j+1]) > 0)
                 {              
            		 temp = x[j];
                     x[j] = x [j+1];
                     x[j+1] = temp; 
                     flag = true;
                 	} 
             	} 
         	} 

         data = x;
         return data;
         }

	
	public void clearFilters() {
		for (int i = 0; i < data.length; i++) {
			data[i] = null;
		}
		retrieveList();
	}
 	
	public Product menuProduct(Product product) {
		Product p = null;
		for (int i = 0; i < data.length; i++) {
			if(data[i].equals(product));
				p = data[i];
		}
		return p;
	}
	
	public Product setUpMenuProducts(int index) {
		return data[index];
	}

	
	public String listProducts() {
		String ans = "";
		for (int i = 0; i < manyItems; i++) {
			if(data[i] == null) {
			}
			else {
				ans += "Description: " + data[i].getDescription() + "\nStatus: " + data[i].getStatus()+ "\nPrice: " + data[i].getPrice()
					+ "\nUser Rating: " + data[i].getRating() + "\n";
		}
		}
		return ans;
	}
	
	public Product[] products() {
		Product[] x = new Product[manyItems];
		for (int i = 0; i < manyItems; i++) {
			x[i]= data[i];
		}
		return x;
	}
}