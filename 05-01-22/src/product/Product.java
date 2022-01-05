package product;

public class Product {
	
	
	private int id = 0;
	private String name;
	private float price;
	
	
	
	public Product() {
	}



	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	


	public Product(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}



	public int getId() {
		return id;
	}




	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}


	
	
	
	
	
	
}
