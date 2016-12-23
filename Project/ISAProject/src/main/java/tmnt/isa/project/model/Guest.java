package tmnt.isa.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="GUEST")
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="GUEST_ID", nullable=false)
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
	
	@ManyToMany
	@JoinTable(name="GUESTS_FRIENDS", joinColumns=@JoinColumn(name="GUEST_ID"), 
			   inverseJoinColumns=@JoinColumn(name="FRIEND_ID")
	)
	@Getter @Setter
	private Collection<Guest> friends;
	
	@OneToMany(mappedBy="guest")
	@Getter @Setter
	private Collection<Evaluation> evaluations;
	
	public Guest() {}
	
	public Guest(String username, String password, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		friends = new ArrayList<Guest>();
		evaluations = new ArrayList<Evaluation>();
	}
}
