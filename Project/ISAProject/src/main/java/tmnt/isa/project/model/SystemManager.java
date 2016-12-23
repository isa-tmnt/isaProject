package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="SYSTEM_MANAGER")
public class SystemManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SM_ID", nullable=false)
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
	
	public SystemManager() {}
	
	public SystemManager(String username, String password, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
