package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long> {
	
	public Staff findByUsername(String username);
	
	public Staff findByEmail(String email);
}
