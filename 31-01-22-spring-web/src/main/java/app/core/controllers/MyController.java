package app.core.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	// set when we map endpoint we define:
	//1. http method 
	//2. path
	// http://localhost:8080/hello
	
//	@RequestMapping(method= RequestMethod.GET,path = {"/x","/y"})// we can set path in array
	@RequestMapping(method= RequestMethod.GET,path = "/hello")
	public String hello() {
		return "Hello spring web world ";
	}
	@RequestMapping(method= RequestMethod.GET,path = "/random")
	public int random() {
		return ((int)(Math.random()*100)+1);
	}
	
	
	
	// http://localhost:8080/sum?a=5&b=100
	@RequestMapping(method= RequestMethod.GET,path = "/sum")
	public int sum (@RequestParam int a, @RequestParam int b) {
						
		return a + b;
	
	}
	// http://localhost:8080/sum?a=5&b=100
	@RequestMapping(method= RequestMethod.GET,path = "/sum2")
	public String sum2 (@RequestParam int a, @RequestParam int b) {
		
		return  a + " + " + b + " = " +(a + b) ;
		
	}
}








