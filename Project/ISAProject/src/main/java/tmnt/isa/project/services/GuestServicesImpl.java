package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Guest;
import tmnt.isa.project.repository.GuestRepository;
import tmnt.isa.project.security.SecurityServices;

@Service
public class GuestServicesImpl implements GuestServices {
	
	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private SecurityServices securityServices;

	@Override
	public ArrayList<Guest> getAllGuests() {
		ArrayList<Guest> guests = new ArrayList<Guest>();
		for(Guest guest : guestRepository.findAll()) {
			guests.add(guest);
		}
		
		return guests;
	}
	
	@Override
	public Guest getGuestByUsername(String username) {
		Guest guest = guestRepository.findByUsername(username);
		if(guest != null) {
			return guest;
		}
		
		return null;
	}
	
	@Override
	public Guest getGuestByEmail(String email) {
		Guest guest = guestRepository.findByEmail(email);
		if(guest != null) {
			return guest;
		}
		
		return null;
	}

	@Override
	public Guest getGuest(Long id) {
		Guest guest = guestRepository.findOne(id);
		if(guest != null) {
			return guest;
		}
		
		return null;
	}
	
	@Override
	public Guest addGuest(Guest guest) {
		boolean b = securityServices.validations(guest.getUsername(), guest.getEmail());
		
		if(b) {
			return guestRepository.save(guest);
		} else {
			return null;
		}
	}

	@Override
	public Guest updateGuest(Long id, Guest guest) {
		Guest g = guestRepository.findOne(id);
		if(g != null) {
			boolean b = securityServices.validationsU(g.getUsername(), g.getEmail(), 
					guest.getUsername(), guest.getEmail()
			);
			
			if(b) {
				return guestRepository.save(guest);
			} else {
				return null;
			}
		}
		
		return null;
	}

	@Override
	public void deleteGuest(Long id) {
		Guest guest = guestRepository.findOne(id);
		if(guest != null) {
			guestRepository.delete(id);
		}
	}
	
	/*@Override
	public ArrayList<Guest> getAllFriends(Long id) {
		Guest guest = guestRepository.findOne(id);
		ArrayList<Guest> friends = new ArrayList<Guest>();
		if(guest != null) {
			for(Guest friend : guest.getFriends()) {
				friends.add(friend);
			}
			
			return friends;
		}
		
		return null;
	}*/
	
	/*@Override
	public ArrayList<Guest> getAllReceivedFriends(Long id) {
		Guest guest = guestRepository.findOne(id);
		ArrayList<Guest> receivedFriends = new ArrayList<Guest>();
		if(guest != null) {
			for(Guest receivedFriend : guest.getReceivedFriends()) {
				receivedFriends.add(receivedFriend);
			}
			
			return receivedFriends;
		}
		
		return null;
	}*/
	
	//TODO 1: guest.getFriends().add(friend) and friend.getFriends().add(guest)
	/*@Override
	public Guest addFriend(Long id, Guest friend) {
		Guest guest = guestRepository.findOne(id);
		if(guest != null) {
			guest.getFriends().add(friend);
			return guestRepository.save(guest);
		}
		
		return null;
	}*/
	
	/*@Override
	public Guest addReceivedFriend(Long id, Guest friend) {
		Guest guest = guestRepository.findOne(id);
		if(guest != null) {
			guest.getReceivedFriends().add(friend);
			return guestRepository.save(guest);
		}
		
		return null;
	}*/
	
	/*@Override
	public Guest deleteFriend(Long guestId, Long friendId) {
		Guest guest = guestRepository.findOne(guestId);
		if(guest != null) {
			for(Guest friend : guest.getFriends()) {
				if(friend.getId() == friendId) {
					guest.getFriends().remove(friend);
				}
			}
			
			return guestRepository.save(guest);
		}
		
		return null;
	}*/
	
	/*@Override
	public Guest deleteReceivedFriend(Long guestId, Long resFriendId) {
		Guest guest = guestRepository.findOne(guestId);
		if(guest != null) {
			for(Guest resFriend : guest.getReceivedFriends()) {
				if(resFriend.getId() == resFriendId) {
					guest.getReceivedFriends().remove(resFriend);
				}
			}
			
			return guestRepository.save(guest);
		}
		
		return null;
	}*/
	
	/*@Override
	public ArrayList<Guest> getAllSentFriends(Long id) {
		Guest guest = guestRepository.findOne(id);
		ArrayList<Guest> sentFriends = new ArrayList<Guest>();
		if(guest != null) {
			for(Guest sentFriend : guest.getSentFriends()) {
				sentFriends.add(sentFriend);
			}
			
			return sentFriends;
		}
		
		return null;
	}
	
	@Override
	public Guest addSentFriend(Long id, Guest friend) {
		Guest guest = guestRepository.findOne(id);
		if(guest != null) {
			guest.getSentFriends().add(friend);
			return guestRepository.save(guest);
		}
		
		return null;
	}
	
	@Override
	public Guest deleteSentFriend(Long guestId, Long sentFriendId) {
		Guest guest = guestRepository.findOne(guestId);
		if(guest != null) {
			for(Guest sentFriend : guest.getSentFriends()) {
				if(sentFriend.getId() == sentFriendId) {
					guest.getReceivedFriends().remove(sentFriend);
				}
			}
			
			return guestRepository.save(guest);
		}
		
		return null;
	}*/
}
