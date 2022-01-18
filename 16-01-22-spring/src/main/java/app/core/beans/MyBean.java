package app.core.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;


@Component
public class MyBean {

	public int value;

	public MyBean() {
		System.out.println(">>> MyBean CTOR");
	}
	
	@PostConstruct
	public void doAfterConstruct() {
		System.out.println(">>>doAfterConstruct<<<");
	}
	
	@PreDestroy
	public void doBeforeConstruct() {
		System.out.println(">>>doBeforeConstruct<<<");
	}

}
