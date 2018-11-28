package projectCBay_code;

public class CartStack {
	
	private Stack<Product> products;
	private int count;

	public CartStack() {
		products = new Stack<>();
		count = 0;
	}
	
	public void addProductToCart(Product p) {
		products.push(p);
		count++;
	}
	
	public void clearCart() {
		products = new Stack<>();
		count = 0;
	}
	
	public double totalCost(){
		double total = 0;
		for (int i = 0; i < count; i++) {
			total += products.pop().getPrice();
		}
		return total;
	}
}
