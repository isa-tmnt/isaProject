package tmnt.isa.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CLIENT")
public class Client extends UserDetails {
	
	@Getter @Setter
	@Column(name="AGE")
	private int age;
	
	public Client() {}
	
	public Client(int age) {
		super();
		this.age = age;
	}
}
