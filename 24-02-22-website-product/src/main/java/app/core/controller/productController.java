package app.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.beans.Product;



@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class productController {

	
	@GetMapping
	public List<Product> getProducts(){
	List<Product> products = new ArrayList<>();
	products.add(new Product(1, "Bread", 5.80, 600));
	products.add(new Product(2, "Milk", 14, 543));
	products.add(new Product(3, "Honey", 26, 600));
	products.add(new Product(1, "Milk", 44, 500));
	products.add(new Product(2, "Honey", 33, 600));
	
	
	return products;
	}
	

	
}
