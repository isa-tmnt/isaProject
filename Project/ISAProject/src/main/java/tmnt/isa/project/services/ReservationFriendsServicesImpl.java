package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Reservation;
import tmnt.isa.project.model.ReservationFriends;
import tmnt.isa.project.repository.ReservationFriendsRepository;
import tmnt.isa.project.repository.ReservationRepository;

@Service
public class ReservationFriendsServicesImpl implements ReservationFriendsServices {
	
	@Autowired
	private ReservationFriendsRepository reservationFriendsRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public ArrayList<ReservationFriends> getAllReservationFriends() {
		ArrayList<ReservationFriends> reservationFriends = new ArrayList<ReservationFriends>();
		for(ReservationFriends reservationFriends2 : reservationFriendsRepository.findAll()) {
			reservationFriends.add(reservationFriends2);
		}
		
		return reservationFriends;
	}

	@Override
	public ReservationFriends getReservationFriends(Long id) {
		ReservationFriends reservationF = reservationFriendsRepository.findOne(id);
		if(reservationF != null) {
			return reservationF;
		}
		
		return null;
	}

	@Override
	public ReservationFriends addReservationFriends(ReservationFriends reservationFriends) {
		int i = 0;
		for(ReservationFriends resFriends : reservationFriendsRepository.findAll()) {
			if(reservationFriends.getReservationId() == resFriends.getReservationId() && 
					reservationFriends.getFriendId() == resFriends.getFriendId()) {
				i++;
			}
		}
		
		if(i == 0) {
			return reservationFriendsRepository.save(reservationFriends);
		} else {
			return null;
		}
	}

	@Override
	public ReservationFriends updateReservationFriends(Long id, ReservationFriends reservationFriends) {
		ReservationFriends rf = reservationFriendsRepository.findOne(id);
		if(rf != null) {
			return reservationFriendsRepository.save(reservationFriends);
		}
		
		return null;
	}

	@Override
	public void deleteReservationFriends(Long id) {
		Reservation reservation = reservationRepository.findOne(id);
		ArrayList<ReservationFriends> reservationFriends = new ArrayList<ReservationFriends>();
		for(ReservationFriends resFriends : reservationFriendsRepository.findAll()) {
			if(resFriends.getReservationId() == reservation.getId()) {
				reservationFriends.add(resFriends);
			}
		}
		
		reservationFriendsRepository.delete(reservationFriends);
	}
}
