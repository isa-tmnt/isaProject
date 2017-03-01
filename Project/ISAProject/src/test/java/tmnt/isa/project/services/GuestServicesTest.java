package tmnt.isa.project.services;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tmnt.isa.project.IsaProjectApplicationTests;
import tmnt.isa.project.model.Guest;

@Transactional
public class GuestServicesTest extends IsaProjectApplicationTests {
	
	@Autowired
	private GuestServices guestServices;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testFindAll() {
		ArrayList<Guest> guests = guestServices.getAllGuests();
		
		assertNotNull("failure - expected not null", guests);
		assertEquals("failure - expected size", 3, guests.size());
		assertNotEquals("success", 1, guests.size());
	}
	
	@Test
	public void testFindOne() {
		Long id = new Long(4);
		Guest guest = guestServices.getGuest(id);
		
		assertNotNull("failure - expected not null", guest);
		assertEquals("failure - expected size", id, guest.getId());
	}
	
	@Test
	public void testFindOneNotFound() {
		Long id = Long.MAX_VALUE;
		Guest guest = guestServices.getGuest(id);
		
		assertNull("failure - expected null", guest);
	}
	
	@Test
	public void testCreate() {
		Guest guest = new Guest("sfafa", "admin123", "sasf@gmail.com", "Will", "Smith");
		
		Guest createdGuest = guestServices.addGuest(guest);
		
		assertNotNull("failure - expected not null", createdGuest);
		assertNotNull("failure - expected id attribute not null", createdGuest.getId());
		assertEquals("failure - expected password attribute match", "admin123", guest.getPassword());
	}
	
	@Test
	public void testUpdate() {
		Long id = new Long(4);
		Guest guest = new Guest("wsmith", "admin123", "sasf@gmail.com", "Will", "Smith");
		guest.setId(id);
		
		Guest updatedGuest = guestServices.updateGuest(id, guest);
		
		assertNotNull("failure - expected updated guest not null", updatedGuest);
		assertEquals("failure - expected id attribute match", id, updatedGuest.getId());
		assertEquals("failure - expected password attribute match", "admin123", updatedGuest.getPassword());
	}
	
	@Test
	public void testUpdateNotFound() {
		Guest guest = new Guest("231gvgh", "admin123", "ooooppp@gmail.com", "Will", "Smith");
		guest.setId(Long.MAX_VALUE);
		
		Guest updatedGuest = guestServices.updateGuest(Long.MAX_VALUE, guest);
		
		assertNull("failure - expected null", updatedGuest);
	}
	
	@Test
	public void testDelete() {
		Long id = new Long(4);
		Guest guest = guestServices.getGuest(id);
		
		assertNotNull("failure - expected not null", guest);
		
		guestServices.deleteGuest(id);
		
		Guest deletedGuest = guestServices.getGuest(id);
		
		assertNull("failure - expected guest to be deleted", deletedGuest);
	}
}
