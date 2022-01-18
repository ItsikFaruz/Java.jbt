package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class App2 {

	public static void main(String[] args) throws InterruptedException {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class);
		System.out.println("App2");
		
		
		Thread.sleep(3000);
		ctx.close();
		System.out.println("App3 END");
		
		
		
		
		
	}

}
