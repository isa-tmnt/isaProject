package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.PendingFriendship;

public interface PendingFriendshipServices {
	
	public ArrayList<PendingFriendship> getAllPendingFriendships();
	
	public PendingFriendship getPendingFriendship(Long id);
	
	public PendingFriendship addPendingFriendship(PendingFriendship pendingFriendship);
	
	public void deletePendingFriendship(Long id);
}
