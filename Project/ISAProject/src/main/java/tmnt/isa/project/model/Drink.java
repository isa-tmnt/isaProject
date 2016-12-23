package tmnt.isa.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Drink {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DRINK_ID", nullable=false)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=true)
	private String shortDescription;
	
	@Column(nullable=false)
	private double price;
	
	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	@OneToMany(mappedBy="drink")
	private Collection<Evaluation> evaluations;
	
	public Drink() {}
	
	public Drink(String name, String shortDescription, double price) {
		super();
		this.name = name;
		this.shortDescription = shortDescription;
		this.price = price;
		evaluations = new ArrayList<Evaluation>();
	}
}
