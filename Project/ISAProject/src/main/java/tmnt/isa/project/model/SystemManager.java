package tmnt.isa.project.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="SYSTEM_MANAGER")
public class SystemManager extends UserDetails {
	
	@Getter @Setter
	private boolean boss;
	
	public SystemManager() {}
	
	public SystemManager(String username, String password, String email, String firstName, String lastName, boolean boss) 
	{
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.boss = boss;
	}
}
