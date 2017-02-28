package tmnt.isa.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	//@OneToOne(optional=false)
	//@JoinColumn(name="GUEST_ID")
	//private Guest guest;
	
	@Column(name="RESERVATION_DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date reservationDate;
	
	@Column(name="RESERVATIONS_DURATION", nullable=false)
	private Double duration; 
	
	public Reservation() {}
	
	public Reservation(Date reservationDate, Double duration, Guest guest, Restaurant restaurant) {
		super();
		this.reservationDate = reservationDate;
		this.duration = duration;
		//this.guest = guest;
		this.restaurant = restaurant;
	}
}
