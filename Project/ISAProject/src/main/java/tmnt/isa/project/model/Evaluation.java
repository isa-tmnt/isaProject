package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EVALUATION")
@Data
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EVALUATION_ID", nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private double value;
	
	@ManyToOne
	@JoinColumn(name="GUEST_ID", nullable=false)
	private Guest guest;
	
	@ManyToOne
	@JoinColumn(name="STAFF_ID")
	private Staff staff;
	
	@ManyToOne
	@JoinColumn(name="DISH_ID")
	private Dish dish;
	
	@ManyToOne
	@JoinColumn(name="DRINK_ID")
	private Drink drink;

	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	public Evaluation() {}
	
	public Evaluation(double value, Guest guest, Dish dish, Drink drink, Restaurant restaurant) {
		super();
		this.value = value;
		this.guest = guest;
		this.dish = dish;
		this.drink = drink;
		this.restaurant = restaurant;
	}
}
