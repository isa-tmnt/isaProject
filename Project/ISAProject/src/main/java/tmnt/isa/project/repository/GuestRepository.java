package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {
	
	public Guest findByUsername(String username);
	
	public Guest findByEmail(String email);
}
