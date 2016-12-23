package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USER_DETAILS")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class UserDetails {
	
	/*@TableGenerator(name = "USER_GEN", 
			table = "ID_GEN", 
			pkColumnName = "GEN_NAME", 
			valueColumnName = "GEN_VAL",
			allocationSize = 1
	)*/
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="ID", unique=true, nullable=false)
	@Getter @Setter
	protected Long id;
	
	@Getter @Setter
	@Column(nullable=false)
	protected String username;
	
	@Getter @Setter
	@Column(nullable=false)
	protected String password;
	
	@Getter @Setter
	@Column(nullable=false)
	protected String email;
	
	@Getter @Setter
	@Column(name="FIRST_NAME", nullable=false)
	protected String firstName;
	
	@Getter @Setter
	@Column(name="LAST_NAME", nullable=false)
	protected String lastName;
	
	public UserDetails() {}
	
	public UserDetails(String username, String password, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
