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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name="RESERVATION")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESERVATION_ID", unique=true, nullable=false)
	private Long id;
	
	//@ManyToOne
	//@JoinColumn(name="RESTAURANT_ID")
	//private Restaurant restaurant;
	
	@Column(name="RESTAURANT_ID", nullable=false)
	private Long restaurantId;
	
	//@OneToOne(optional=false)
	//@JoinColumn(name="GUEST_ID")
	//private Guest guest;
	
	@Column(name="GUEST_ID", nullable=false)
	private Long guestId;
	
	@Column(name="RESERVATION_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservationDate;
	
	@Column(name="RESERVATIONS_DURATION", nullable=false)
	private Double duration; 
	
	public Reservation() {}

	public Reservation(Long restaurantId, Long guestId, Date reservationDate, Double duration) {
		super();
		this.restaurantId = restaurantId;
		this.guestId = guestId;
		this.reservationDate = reservationDate;
		this.duration = duration;
	}
}
