package tmnt.isa.project.services;

import java.util.ArrayList;
import tmnt.isa.project.model.Guest;

public interface GuestServices {
	
	public ArrayList<Guest> getAllGuests();
	
	public Guest getGuest(Long id);
	
	public Guest getGuestByUsername(String username);
	
	public Guest getGuestByEmail(String email);
	
	public Guest addGuest(Guest guest);
	
	public Guest updateGuest(Long id, Guest guest);
	
	public void deleteGuest(Long id);
	
	//public ArrayList<Guest> getAllFriends(Long id);
	
	//public ArrayList<Guest> getAllReceivedFriends(Long id);
	
	//public Guest addFriend(Long id, Guest friend);
	
	//public Guest addReceivedFriend(Long id, Guest friend);
	
	//public Guest deleteFriend(Long guestId, Long friendId);
	
	//public Guest deleteReceivedFriend(Long guestId, Long resFriendId);
	
	//public ArrayList<Guest> getAllSentFriends(Long id);
	
	//public Guest addSentFriend(Long id, Guest friend);
	
	//public Guest deleteSentFriend(Long guestId, Long senFriendId);
}
