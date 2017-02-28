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

import tmnt.isa.project.model.Staff;
import tmnt.isa.project.services.StaffServices;

@RestController
@RequestMapping(
	value="/api/staff",
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
public class StaffController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StaffServices staffServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ArrayList<Staff> getStaff() {
		logger.info("> getStaff");
		ArrayList<Staff> staff = staffServices.getAllStaff();
		logger.info("< getStaff");
		return staff;
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Staff getOneStaff(@PathVariable("id") Long id) {
		return staffServices.getStaff(id);
	}*/
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public Staff getStaffByUsername(@PathVariable("username") String username) {
		return staffServices.getStaffByUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Staff addStaff(@RequestBody Staff staff) {
		return staffServices.addStaff(staff);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Staff updateStaff(@PathVariable("id") Long id, @RequestBody Staff staff) {
		staff.setId(id);
		return staffServices.updateStaff(id, staff);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStaff(@PathVariable("id") Long id) {
		staffServices.deleteStaff(id);
	}
}
