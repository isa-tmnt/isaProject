package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.SystemManager;

public interface SystemManagerServices {
	
	public ArrayList<SystemManager> getAllSystemManagers();
	
	public SystemManager getSystemManager(Long id);
	
	public SystemManager getSystemManagerByUsername(String username);
	
	public SystemManager getSystemManagerByEmail(String email);
	
	public SystemManager addSystemManager(SystemManager systemManager);
	
	public SystemManager updateSystemManager(Long id, SystemManager systemManager);
	
	public void deleteSystemManager(Long id);
}
