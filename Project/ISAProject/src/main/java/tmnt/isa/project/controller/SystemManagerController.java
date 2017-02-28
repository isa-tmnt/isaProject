package tmnt.isa.project.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tmnt.isa.project.model.SystemManager;
import tmnt.isa.project.services.SystemManagerServices;

@RestController
@RequestMapping(
		value="/api/sysmanagers",
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemManagerController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SystemManagerServices systemManagerServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<SystemManager> getSystemManagers() {
		logger.info("> getSystemManagers");
		ArrayList<SystemManager> systemManagers = systemManagerServices.getAllSystemManagers();
		logger.info("< getSystemManagers");
		return systemManagers;
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public SystemManager getSystemManager(@PathVariable("id") Long id) {
		return systemManagerServices.getSystemManager(id);
	}*/
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public SystemManager getSystemManagerByUsername(@PathVariable("username") String username) {
		return systemManagerServices.getSystemManagerByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public SystemManager addSystemManager(@RequestBody SystemManager systemManager) {
		return systemManagerServices.addSystemManager(systemManager);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public SystemManager updateSystemManager(@PathVariable("id") Long id, @RequestBody SystemManager systemManager) {
		systemManager.setId(id);
		return systemManagerServices.updateSystemManager(id, systemManager);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSystemManager(@PathVariable("id") Long id) {
		systemManagerServices.deleteSystemManager(id);
	}
}
