package tmnt.isa.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="SUPPLIER")
public class Supplier extends UserDetails {
	
	@ManyToMany
	@JoinTable(name="SUPPLIERS_GROCERIES", joinColumns=@JoinColumn(name="SUPPLIER_ID"), 
	   		   inverseJoinColumns=@JoinColumn(name="GROCERIES_ID")
	)
	@Getter @Setter
	private Collection<Groceries> groceries;
	
	public Supplier() {}
	
	public Supplier(String username, String password, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.groceries = new ArrayList<Groceries>();
	}
}
