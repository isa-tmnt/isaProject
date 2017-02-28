package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.Groceries;

public interface GroceriesRepository extends CrudRepository<Groceries, Long> {
	
	public Groceries findByName(String name);
}
