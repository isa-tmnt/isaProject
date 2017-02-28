package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="FRIENDSHIP")
@Data
public class Friendship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="FRIENDSHIP_ID", unique=true, nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private Long currentGuestId;
	
	@Column(nullable=false)
	private Long friendId;
	
	public Friendship() {}

	public Friendship(Long currentGuestId, Long friendId) {
		super();
		this.currentGuestId = currentGuestId;
		this.friendId = friendId;
	}
}
