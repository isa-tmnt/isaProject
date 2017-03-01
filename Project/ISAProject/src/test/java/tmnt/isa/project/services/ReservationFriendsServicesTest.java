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
import tmnt.isa.project.model.ReservationFriends;

@Transactional
public class ReservationFriendsServicesTest extends IsaProjectApplicationTests {
	
	@Autowired
	private ReservationFriendsServices reservationFriendsServices;
	
	@Test
	public void testFindAll() {
		ArrayList<ReservationFriends> reservationFriends = reservationFriendsServices.getAllReservationFriends();
		
		assertNotNull("failure - expected not null", reservationFriends);
		assertEquals("failure - expected size", 4, reservationFriends.size());
		assertNotEquals("success", 1, reservationFriends.size());
	}
	
	@Test
	public void testFindOne() {
		Long id = new Long(11);
		ReservationFriends reservationFriends = reservationFriendsServices.getReservationFriends(id);
		
		assertNotNull("failure - expected not null", reservationFriends);
		assertEquals("failure - expected size", id, reservationFriends.getId());
	}
	
	@Test
	public void testFindOneNotFound() {
		Long id = Long.MAX_VALUE;
		ReservationFriends reservationFriends = reservationFriendsServices.getReservationFriends(id);
		
		assertNull("failure - expected null", reservationFriends);
	}
	
	@Test
	public void testCreate() {
		ReservationFriends reservationFriends = new ReservationFriends(new Long(4), new Long(5));
		
		ReservationFriends createdReservationFriends = reservationFriendsServices.addReservationFriends(reservationFriends);
		
		assertNotNull("failure - expected not null", createdReservationFriends);
		assertNotNull("failure - expected id attribute not null", createdReservationFriends.getId());
	}
}
