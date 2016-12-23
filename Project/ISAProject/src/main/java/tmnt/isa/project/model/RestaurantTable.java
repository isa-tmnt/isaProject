package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="RESTAURANT_TABLE")
@Data
public class RestaurantTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TABEL_ID", unique=true, nullable=false)
	private Long id;
	
	@Column(name="ZONE", length=30)
	@Enumerated(EnumType.STRING)
	private ZoneType zone;
	
	@ManyToOne
	@JoinColumn(name="GUEST_ID")
	private Guest occupier;
	
	private boolean occupied;	//reserved
	
	public RestaurantTable() {}
	
	public RestaurantTable(ZoneType zone) {
		super();
		this.zone = zone;
	}
}
