package app.core.beans;

import org.springframework.stereotype.Component;

import app.core.annotations.MyLogAnnotation;

@Component
@MyLogAnnotation
public class MyDao {

	public void save() {
		System.out.println("dao is saving");
	}
	
	public void find(int id) {
		System.out.println("dao is finding "  + id);
	}
	
	@MyLogAnnotation
	public void delete() {
		System.out.println("dao is deleting");
	}
	
	
}
