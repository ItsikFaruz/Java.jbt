package app.core.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString (exclude ="customers")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coupon {

	public enum Category {
		FOOD, ELECTRICITY, RESTURANT, VACATION, TRAVEL;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Category category;
	private String title;
	private String description;
	@JoinColumn(name="start_date")
	private LocalDate startDate;
	@JoinColumn(name="end_date")
	private LocalDate endDate;
	private int amount;
	private double price;
	private String image;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "company_id")
	private Company company;
	

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable (name= "customer_coupon" , joinColumns = @JoinColumn(name = "coupon_id"), inverseJoinColumns =  @JoinColumn(name = "customer_id"))
	private List<Customer> customers;

}
