package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.ReservationFriends;
import tmnt.isa.project.repository.ReservationFriendsRepository;

@Service
public class ReservationFriendsServicesImpl implements ReservationFriendsServices {
	
	@Autowired
	private ReservationFriendsRepository reservationFriendsRepository;

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
		return reservationFriendsRepository.save(reservationFriends);
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
		ReservationFriends reservationF = reservationFriendsRepository.findOne(id);
		if(reservationF != null) {
			reservationFriendsRepository.delete(id);
		}
	}
}
