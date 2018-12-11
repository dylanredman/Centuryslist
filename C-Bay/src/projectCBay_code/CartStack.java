package projectCBay_code;

public class CartStack {
	
	private Stack<Product> products;
	private int count;
	private double total;

	public CartStack() {
		products = new Stack<>();
		count = 0;
		total = 0;
	}
	
	public void addProductToCart(Product p) {
		products.push(p);
		count++;
	}
	
	public void clearCart() {
		products = new Stack<>();
		count = 0;
	}
	
	public void remove(Product product) {
		Stack<Product> temp = new Stack<Product>();
		for (int i = 0; i < count; i++) {
			Product p = products.peek();
			if(p == null) {
			}
			else if(p.equals(product)){
				products.pop();
			}
			else {
				temp.push(products.pop());
			}
		}
		products = temp;
	}
	
	public double totalCost(){
		double total = 0;
		for (int i = 0; i < count; i++) {
			if(products.peek() != null)
			total += products.pop().getPrice();
		}
		return total;
	}	
}
