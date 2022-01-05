package product;

public class Test {

	public static void main(String[] args) {
 
		
		ProductDao productDao = new ProductDao();
		
		try {
			
		//	for (int i = 0; i <10; i++) {
				
			//	Product product = new Product ("book"+i, 25.5F+2*i);
			//	productDao.save(product);
				
				//productDao.delete(11);
			productDao.print();
				
		//	}
			
			
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
			
		}
		
		System.out.println("ended");
	}

}
