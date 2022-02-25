package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import app.core.filter.MyFilter;
import app.core.jwt.util.JwtUtil;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	// register and map the filter
	@Bean
	public FilterRegistrationBean<MyFilter> myFilter(JwtUtil jwtUtil){
	FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
	MyFilter myFilter = new MyFilter(jwtUtil);
	filterRegistrationBean.setFilter(myFilter);
	filterRegistrationBean.addUrlPatterns("/api/*");
	return filterRegistrationBean;
	}
}
