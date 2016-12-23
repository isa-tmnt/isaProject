package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESERVATION_ID", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	@OneToOne(optional=false)
	@JoinColumn(name="GUEST_ID")
	private Guest guest;
	
	public Reservation() {}
	
	public Reservation(Guest guest, Restaurant restaurant) {
		super();
		this.guest = guest;
		this.restaurant = restaurant;
	}
}
