package app.beans;

public class Painting {

	private int id;
	private String title;
	private String artist;
	private int price;
	
	
	  public Painting() {
		
	} Painting(int id, String title, String artist, int price) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
		
}
