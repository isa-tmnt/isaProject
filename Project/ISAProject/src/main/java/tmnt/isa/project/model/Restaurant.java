package tmnt.isa.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESTAURANT_ID", nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(name="TYPE_DESCRIPTION", nullable=false)
	private String typeDescription;
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Dish> dishMenu = new ArrayList<Dish>();
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Drink> drinkMenu = new ArrayList<Drink>();
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Staff> staff = new ArrayList<Staff>();
	
	@OneToMany(mappedBy="restaurant")
	private Collection<RestaurantManager> restaurantManagers = new ArrayList<RestaurantManager>();
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Evaluation> evaluations = new ArrayList<Evaluation>();
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Reservation> reservations = new ArrayList<Reservation>();
	
	public Restaurant() {}
	
	public Restaurant(String name, String typeDescription) {
		super();
		this.name = name;
		this.typeDescription = typeDescription;
		this.staff = new ArrayList<Staff>();
		this.restaurantManagers = new ArrayList<RestaurantManager>();
		this.evaluations = new ArrayList<Evaluation>();
		this.dishMenu = new ArrayList<Dish>();
		this.drinkMenu = new ArrayList<Drink>();
		this.reservations = new ArrayList<Reservation>();
	}
}
