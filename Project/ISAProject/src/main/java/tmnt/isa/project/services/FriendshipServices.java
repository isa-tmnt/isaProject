package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.Friendship;

public interface FriendshipServices {
		
	public ArrayList<Friendship> getAllFriendships();
	
	public Friendship getFriendship(Long id);
	
	public Friendship addFriendship(Friendship friendship);
	
	public void deleteFriendship(Long id);
}
