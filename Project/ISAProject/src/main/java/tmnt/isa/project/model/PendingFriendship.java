package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PENDING_FRIENDSHIP")
@Data
public class PendingFriendship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PENDING_FRIENDSHIP_ID", unique=true, nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private Long currentGuestId;
	
	@Column(nullable=false)
	private Long penFriendId;
	
	public PendingFriendship() {}

	public PendingFriendship(Long currentGuestId, Long penFriendId) {
		super();
		this.currentGuestId = currentGuestId;
		this.penFriendId = penFriendId;
	}
}
