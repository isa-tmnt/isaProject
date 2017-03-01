package tmnt.isa.project.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tmnt.isa.project.IsaProjectApplicationTests;
import tmnt.isa.project.model.Reservation;

@Transactional
public class ReservationServicesTest extends IsaProjectApplicationTests {
	
	@Autowired
	private ReservationServices reservationServices;
	
	@Test
	public void testFindAll() {
		ArrayList<Reservation> reservations = reservationServices.getAllReservations();
		
		assertNotNull("failure - expected not null", reservations);
		assertEquals("failure - expected size", 2, reservations.size());
		assertNotEquals("success", 1, reservations.size());
	}
	
	@Test
	public void testFindOne() {
		Long id = new Long(1);
		Reservation reservation = reservationServices.getReservation(id);
		
		assertNotNull("failure - expected not null", reservation);
		assertEquals("failure - expected size", id, reservation.getId());
	}
	
	@Test
	public void testFindOneNotFound() {
		Long id = Long.MAX_VALUE;
		Reservation reservation = reservationServices.getReservation(id);
		
		assertNull("failure - expected null", reservation);
	}
	
	@Test
	public void testCreate() {
		Reservation reservation = new Reservation(new Long(3), new Long(3), new Date(), 2.0);
		
		Reservation createdReservation = reservationServices.addReservation(reservation);
		
		assertNotNull("failure - expected not null", createdReservation);
		assertNotNull("failure - expected id attribute not null", createdReservation.getId());
		assertEquals("failure - expected attribute match", reservation.getGuestId(), createdReservation.getGuestId());
	}
	
	@Test
	public void testDelete() {
		Long id = new Long(1);
		Reservation reservation = reservationServices.getReservation(id);
		
		assertNotNull("failure - expected not null", reservation);
		
		reservationServices.deleteReservation(id);
		
		Reservation deletedReservation = reservationServices.getReservation(id);
		
		assertNull("failure - expected friendship to be deleted", deletedReservation);
	}
}
