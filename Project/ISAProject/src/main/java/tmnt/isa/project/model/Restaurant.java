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
	private Collection<Dish> dishMenu;
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Drink> drinkMenu;
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Staff> staff;
	
	@OneToMany(mappedBy="restaurant")
	private Collection<RestaurantManager> restaurantManagers;
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Evaluation> evaluations;
	
	@OneToMany(mappedBy="restaurant")
	private Collection<Reservation> reservations;
	
	public Restaurant() {}
	
	public Restaurant(String name, String typeDescription) {
		super();
		this.name = name;
		this.typeDescription = typeDescription;
		staff = new ArrayList<Staff>();
		restaurantManagers = new ArrayList<RestaurantManager>();
		evaluations = new ArrayList<Evaluation>();
		dishMenu = new ArrayList<Dish>();
		drinkMenu = new ArrayList<Drink>();
	}
}
