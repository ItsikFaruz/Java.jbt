package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.Gym;


@Configuration
@ComponentScan
@PropertySource ("application.properties")
public class App2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class)) {
		
			Gym gym = ctx.getBean(Gym.class);
			
			System.out.println(gym.getRunning().getTrainProgram());
			System.out.println(gym.getSwimm().getTrainProgram());
			System.out.println(gym.getTennis().getTrainProgram());
		
			
		}
	}
}