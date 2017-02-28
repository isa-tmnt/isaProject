package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Friendship;
import tmnt.isa.project.model.PendingFriendship;
import tmnt.isa.project.repository.FriendshipRepository;
import tmnt.isa.project.repository.PendingFriendshipRepository;

@Service
public class PendingFriendshipServicesImpl implements PendingFriendshipServices {
	
	@Autowired
	private PendingFriendshipRepository pendingFriendshipRepository;
	
	@Autowired
	private FriendshipRepository friendshipRepository;

	@Override
	public ArrayList<PendingFriendship> getAllPendingFriendships() {
		ArrayList<PendingFriendship> pendingFriendships = new ArrayList<PendingFriendship>();
		for(PendingFriendship pendingFriendship : pendingFriendshipRepository.findAll()) {
			pendingFriendships.add(pendingFriendship);
		}
		
		return pendingFriendships;
	}

	@Override
	public PendingFriendship getPendingFriendship(Long id) {
		PendingFriendship pendingFriendship = pendingFriendshipRepository.findOne(id);
		if(pendingFriendship != null) {
			return pendingFriendship;
		}
		
		return null;
	}

	@Override
	public PendingFriendship addPendingFriendship(PendingFriendship pendingFriendship) {
		int i = 0;
		for(PendingFriendship pendingFriend : pendingFriendshipRepository.findAll()) {
			if(pendingFriendship.getCurrentGuestId() == pendingFriend.getCurrentGuestId() && pendingFriendship.getPenFriendId() == pendingFriend.getPenFriendId()) {
				i++;
			}
		}
		
		for(Friendship friend : friendshipRepository.findAll()) {
			if(pendingFriendship.getCurrentGuestId() == friend.getCurrentGuestId() && pendingFriendship.getPenFriendId() == friend.getFriendId()) {
				i++;
			}
		}
		
		if(i == 0) {
			return pendingFriendshipRepository.save(pendingFriendship);
		} else {
			return null;
		}
	}

	@Override
	public void deletePendingFriendship(Long id) {
		PendingFriendship pendingFriendship = pendingFriendshipRepository.findOne(id);
		if(pendingFriendship != null) {
			pendingFriendshipRepository.delete(id);
		}
	}
}
