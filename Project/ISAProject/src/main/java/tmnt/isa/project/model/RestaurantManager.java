package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="RESTAURANT_MANAGER")
public class RestaurantManager extends UserDetails {
	
	//@Getter @Setter
	//@ManyToOne
	//@JoinColumn(name="RESTAURANT_ID", nullable=false, referencedColumnName="RESTAURANT_ID")
	//private Restaurant restaurant;
	
	@Getter @Setter
	@Column(name="RESTAURANT_ID", nullable=false)
	private Long restaurantId;
	
	public RestaurantManager() {}
	
	public RestaurantManager(String username, String password, String email, String firstName, String lastName, Long restaurantId) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.restaurantId = restaurantId;
	}
}
