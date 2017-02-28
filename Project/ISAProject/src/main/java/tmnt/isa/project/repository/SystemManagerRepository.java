package tmnt.isa.project.repository;

import org.springframework.data.repository.CrudRepository;

import tmnt.isa.project.model.SystemManager;

public interface SystemManagerRepository extends CrudRepository<SystemManager, Long> {
	
	public SystemManager findByUsername(String username);
	
	public SystemManager findByEmail(String email);
}
