package projectCBay_code;

public class Product implements Comparable<Product>{

	private String picture;
	private String description;
	private double price;
	private int rating;
	private String type;
	private String contactInfo;
	private String status;
	
	
	public Product(String description, double price, int rating, String type, String contactInfo,
			String status, String picture) {
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.type = type;
		this.contactInfo = contactInfo;
		this.status = status;
		this.picture = picture;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public String list() {
		return description + "," + status + "," + price + "," + rating + "," + type
				+ "," + contactInfo;
	}


	@Override
	public String toString() {
		return description + "    $" + price;
	}


	public int compareTo(Product product) {
		int compareInt = this.description.compareTo(product.description);
		if(compareInt < 0)
			return -1;
		if(compareInt > 0)
			return 1;
		return 0;
	}

}
