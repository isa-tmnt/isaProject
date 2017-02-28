package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.SystemManager;
import tmnt.isa.project.repository.SystemManagerRepository;
import tmnt.isa.project.security.SecurityServices;

@Service
public class SystemManagerServicesImpl implements SystemManagerServices {
	
	@Autowired
	private SystemManagerRepository systemManagerRepository;
	
	@Autowired
	private SecurityServices securityServices;

	@Override
	public ArrayList<SystemManager> getAllSystemManagers() {
		ArrayList<SystemManager> systemManagers = new ArrayList<SystemManager>();
		for(SystemManager systemManager : systemManagerRepository.findAll()) {
			systemManagers.add(systemManager);
		}
		
		return systemManagers;
	}

	@Override
	public SystemManager getSystemManager(Long id) {
		SystemManager systemManager = systemManagerRepository.findOne(id);
		if(systemManager != null) {
			return systemManager;
		}
		
		return null;
	}

	@Override
	public SystemManager getSystemManagerByUsername(String username) {
		SystemManager systemManager = systemManagerRepository.findByUsername(username);
		if(systemManager != null) {
			return systemManager;
		}
		
		return null;
	}
	
	@Override
	public SystemManager getSystemManagerByEmail(String email) {
		SystemManager systemManager = systemManagerRepository.findByEmail(email);
		if(systemManager != null) {
			return systemManager;
		}
		
		return null;
	}

	@Override
	public SystemManager addSystemManager(SystemManager systemManager) {
		boolean b = securityServices.validations(systemManager.getUsername(), systemManager.getEmail());
		
		if(b) {
			return systemManagerRepository.save(systemManager);
		} else {
			return null;
		}
	}

	@Override
	public SystemManager updateSystemManager(Long id, SystemManager systemManager) {
		SystemManager s = systemManagerRepository.findOne(id);
		if(s != null) {
			boolean b = securityServices.validationsU(s.getUsername(), s.getEmail(), 
					systemManager.getUsername(), systemManager.getEmail()
			);
			
			if(b) {
				return systemManagerRepository.save(systemManager);
			} else {
				return null;
			}
		}
		
		return null;
	}

	@Override
	public void deleteSystemManager(Long id) {
		SystemManager systemManager = systemManagerRepository.findOne(id);
		if(systemManager != null) {
			systemManagerRepository.delete(id);
		}
	}
}
