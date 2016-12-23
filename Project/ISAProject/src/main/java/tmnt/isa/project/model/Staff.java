package tmnt.isa.project.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="STAFF")
public class Staff{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STAFF_ID", unique=true, nullable=false)
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	@Column(nullable=false)
	private String username;
	
	@Getter @Setter
	@Column(nullable=false)
	private String password;
	
	@Getter @Setter
	@Column(nullable=false)
	private String email;
	
	@Getter @Setter
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;
	
	@Getter @Setter
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
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
	@Column(name="ROLE", length=10)
	@Enumerated(EnumType.STRING)
	private StaffType role;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;
	
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
	}
}
