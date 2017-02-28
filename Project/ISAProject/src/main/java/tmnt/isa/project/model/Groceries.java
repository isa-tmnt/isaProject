package tmnt.isa.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="GROCERIES")
@Data
public class Groceries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="GROCERIES_ID", unique=true, nullable=false)
	private Long id;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="QUANTITY", nullable=false)
	private int quantity;
	
	@ManyToMany(mappedBy="groceries")
	private Collection<Supplier> suppliers = new ArrayList<Supplier>();
	
	public Groceries() {}
	
	public Groceries(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.suppliers = new ArrayList<Supplier>();
	}
}
