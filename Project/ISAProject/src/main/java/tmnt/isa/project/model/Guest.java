package tmnt.isa.project.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="GUEST")
public class Guest extends UserDetails {
	
	/*@ManyToMany
	@JoinTable(name="GUESTS_FRIENDS", joinColumns=@JoinColumn(name="GUEST_ID"), 
			   inverseJoinColumns=@JoinColumn(name="FRIEND_ID")
	)
	@Getter @Setter
	private Collection<Guest> friends = new ArrayList<Guest>();*/
	
	//List of received requests
	/*@ManyToMany
	@JoinTable(name="GUESTS_RECEIVED_FRIENDS", joinColumns=@JoinColumn(name="GUEST_ID"), 
			   inverseJoinColumns=@JoinColumn(name="RECEIVED_FRIEND_ID")
	)
	@Getter @Setter
	private Collection<Guest> receivedFriends = new ArrayList<Guest>();
	
	//List of sent requests
	@ManyToMany
	@JoinTable(name="GUESTS_SENT_FRIENDS", joinColumns=@JoinColumn(name="GUEST_ID"), 
			   inverseJoinColumns=@JoinColumn(name="SENT_FRIEND_ID")
	)
	@Getter @Setter
	private Collection<Guest> sentFriends = new ArrayList<Guest>();*/
	
	/*@OneToMany(mappedBy="currentGuest")
	@Getter @Setter
	private Collection<Friendship> friendships = new ArrayList<Friendship>();
	
	@OneToMany(mappedBy="friend")
	@Getter @Setter
	private Collection<Friendship> friendships1 = new ArrayList<Friendship>();*/
	
	@OneToMany(mappedBy="guest")
	@Getter @Setter
	private Collection<Evaluation> evaluations = new ArrayList<Evaluation>();
	
	public Guest() {}
	
	public Guest(String username, String password, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.friends = new ArrayList<Guest>();
		//this.receivedFriends = new ArrayList<Guest>();
		//this.sentFriends = new ArrayList<Guest>();
		this.evaluations = new ArrayList<Evaluation>();
	}
}
