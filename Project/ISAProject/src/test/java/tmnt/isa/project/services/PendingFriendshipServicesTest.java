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
import tmnt.isa.project.model.PendingFriendship;

@Transactional
public class PendingFriendshipServicesTest extends IsaProjectApplicationTests {
	
	@Autowired
	private PendingFriendshipServices pendingFriendshipServices;
	
	@Test
	public void testFindAll() {
		ArrayList<PendingFriendship> pendingFriendships = pendingFriendshipServices.getAllPendingFriendships();
		
		assertNotNull("failure - expected not null", pendingFriendships);
		assertEquals("failure - expected size", 0, pendingFriendships.size());
		assertNotEquals("success", 1, pendingFriendships.size());
	}
	
	@Test
	public void testFindOneNotFound() {
		Long id = Long.MAX_VALUE;
		PendingFriendship pendingFriendship = pendingFriendshipServices.getPendingFriendship(id);
		
		assertNull("failure - expected null", pendingFriendship);
	}
	
	@Test
	public void testCreate() {
		PendingFriendship pendingFriendship = new PendingFriendship(new Long(4), new Long(5));
		
		PendingFriendship createdPendingFriendship = pendingFriendshipServices.addPendingFriendship(pendingFriendship);
		
		assertNotNull("failure - expected not null", createdPendingFriendship);
		assertNotNull("failure - expected id attribute not null", createdPendingFriendship.getId());
		assertEquals("failure - expected password attribute match", new Long(4), createdPendingFriendship.getCurrentGuestId());
	}
	
	@Test
	public void testDelete() {
		PendingFriendship pendingFriendship1 = new PendingFriendship(new Long(4), new Long(5));
		pendingFriendshipServices.addPendingFriendship(pendingFriendship1);
		
		PendingFriendship pendingFriendship = pendingFriendshipServices.getPendingFriendship(pendingFriendship1.getId());
		
		assertNotNull("failure - expected not null", pendingFriendship);
		
		pendingFriendshipServices.deletePendingFriendship(pendingFriendship1.getId());
		
		PendingFriendship deletedPendingFriendship = pendingFriendshipServices.getPendingFriendship(pendingFriendship1.getId());
		
		assertNull("failure - expected friendship to be deleted", deletedPendingFriendship);
	}
}
