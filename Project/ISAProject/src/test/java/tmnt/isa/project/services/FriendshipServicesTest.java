package tmnt.isa.project.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tmnt.isa.project.IsaProjectApplicationTests;
import tmnt.isa.project.model.Friendship;

@Transactional
public class FriendshipServicesTest extends IsaProjectApplicationTests {
	
	@Autowired
	private FriendshipServices friendshipServices;
	
	@Test
	public void testFindAll() {
		ArrayList<Friendship> friendships = friendshipServices.getAllFriendships();
		
		assertNotNull("failure - expected not null", friendships);
		assertEquals("failure - expected size", 4, friendships.size());
		assertNotEquals("success", 1, friendships.size());
	}
	
	@Test
	public void testFindOne() {
		Long id = new Long(4);
		Friendship friendship = friendshipServices.getFriendship(id);
		
		assertNotNull("failure - expected not null", friendship);
		assertEquals("failure - expected size", id, friendship.getId());
	}
	
	@Test
	public void testFindOneNotFound() {
		Long id = Long.MAX_VALUE;
		Friendship friendship = friendshipServices.getFriendship(id);
		
		assertNull("failure - expected null", friendship);
	}
	
	@Test
	public void testCreate() {
		Friendship friendship = new Friendship(new Long(4), new Long(5));
		
		Friendship createdFriendship = friendshipServices.addFriendship(friendship);
		
		assertNotNull("failure - expected not null", createdFriendship);
		assertNotNull("failure - expected id attribute not null", createdFriendship.getId());
		assertEquals("failure - expected attribute match", new Long(4), createdFriendship.getCurrentGuestId());
	}
	
	@Test
	public void testDelete() {
		Long id = new Long(4);
		Friendship friendship = friendshipServices.getFriendship(id);
		
		assertNotNull("failure - expected not null", friendship);
		
		friendshipServices.deleteFriendship(id);
		
		Friendship deletedFriendship = friendshipServices.getFriendship(id);
		
		assertNull("failure - expected friendship to be deleted", deletedFriendship);
	}
}
