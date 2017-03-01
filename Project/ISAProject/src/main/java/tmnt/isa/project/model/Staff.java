package tmnt.isa.project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="STAFF")
public class Staff extends UserDetails {
	
	@Getter @Setter
	@Column(name="DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Getter @Setter
	@Column(name="CLOTHING_SIZE")
	private int clothingSize;
	
	@Getter @Setter
	@Column(name="SHOE_SIZE")
	private int shoeSize; 
	
	@Getter @Setter
	@Column(name="ROLE")
	@Enumerated(EnumType.STRING)
	private StaffType role;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
	@Getter @Setter
	@OneToMany(mappedBy="staff")
	private Collection<Evaluation> evaluations = new ArrayList<Evaluation>(); 
	
	public Staff() {}
	
	public Staff(String username, String password, String email, String firstName, String lastName, 
				 Date dateOfBirth, int clothingSize, int shoeSize, StaffType role) 
	{
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.clothingSize = clothingSize;
		this.shoeSize = shoeSize;
		this.role = role;
		this.evaluations = new ArrayList<Evaluation>();
	}
}
