package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.Friendship;

public interface FriendshipRepository extends CrudRepository<Friendship, Long> {
	
	//public ArrayList<Friendship> findByCurrentGuestId(Long id);
}
