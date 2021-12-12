package c;

public class Person {
	
	private int id;
	private String name;
	private int age;
	private int hight;
	
	public Person() {}
	
	
	public Person(int id, String name, int age, int hight) {
		this.id = id;
		this.name = name; 
		this.age = age;
		this.hight = hight;		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	

}
