package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
	
	public Supplier findByUsername(String username);
	
	public Supplier findByEmail(String email);
}
