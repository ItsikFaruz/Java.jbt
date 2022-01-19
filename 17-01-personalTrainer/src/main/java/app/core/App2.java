package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.Gym;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class App2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class)) {

			String[] arr = ctx.getBeanDefinitionNames();
			for (String beanName : arr) {
				System.out.println(beanName);
			}

			Gym gym = ctx.getBean(Gym.class);
			System.out.println("======================");
			System.out.println(gym.getRunningTrainer().getTrainProgram());
			System.out.println(gym.getSwimmingTrainer().getTrainProgram());
			System.out.println(gym.getTennisTrainer().getTrainProgram());

		}
	}
}