package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="RESTAURANT_MANAGER")
public class RestaurantManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RM_ID", nullable=false)
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	@Column(nullable=false)
	private String username;
	
	@Getter @Setter
	@Column(nullable=false)
	private String password;
	
	@Getter @Setter
	@Column(nullable=false)
	private String email;
	
	@Getter @Setter
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Getter @Setter
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	public RestaurantManager() {}
	
	public RestaurantManager(String username, String password, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
