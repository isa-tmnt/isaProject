package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.ReservationFriends;

public interface ReservationFriendsServices {
	
	public ArrayList<ReservationFriends> getAllReservationFriends();
	
	public ReservationFriends getReservationFriends(Long id);

	public ReservationFriends addReservationFriends(ReservationFriends reservationFriends);
	
	public ReservationFriends updateReservationFriends(Long id, ReservationFriends reservationFriends);
	
	public void deleteReservationFriends(Long id);
}
