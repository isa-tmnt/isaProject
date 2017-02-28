package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Friendship;
import tmnt.isa.project.repository.FriendshipRepository;

@Service
public class FriendshipServicesImpl implements FriendshipServices {

	@Autowired
	private FriendshipRepository friendshipRepository;
	
	@Override
	public ArrayList<Friendship> getAllFriendships() {
		ArrayList<Friendship> friendships = new ArrayList<Friendship>();
		for(Friendship friend : friendshipRepository.findAll()) {
			friendships.add(friend);
		}
		
		return friendships;
	}

	@Override
	public Friendship getFriendship(Long id) {
		Friendship friendship = friendshipRepository.findOne(id);
		if(friendship != null) {
			return friendship;
		}
		
		return null;
	}

	@Override
	public Friendship addFriendship(Friendship friendship) {
		return friendshipRepository.save(friendship);
	}

	@Override
	public void deleteFriendship(Long id) {
		Friendship friendship = friendshipRepository.findOne(id);
		ArrayList<Friendship> friendships = new ArrayList<Friendship>();
		friendships.add(friendship);
		
		for(Friendship friend : friendshipRepository.findAll()) {
			if(friendship.getCurrentGuestId() == friend.getFriendId() && 
					friendship.getFriendId() == friend.getCurrentGuestId()) {
				friendships.add(friend);
			}
		}
		
		friendshipRepository.delete(friendships);
	}
}
