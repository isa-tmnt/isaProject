package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="RESERVATION_FRIENDS")
public class ReservationFriends {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESERVATION_FRIENDS_ID", unique=true, nullable=false)
	private Long id;
	
	@Column(name="RESERVATION_ID", nullable=false)
	private Long reservationId;
	
	@Column(name="FRIEND_ID")
	private Long friendId;
	
	public ReservationFriends() {}

	public ReservationFriends(Long reservationId, Long friendId) {
		super();
		this.reservationId = reservationId;
		this.friendId = friendId;
	}
}
