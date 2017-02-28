package tmnt.isa.project.services;

import java.util.ArrayList;

import tmnt.isa.project.model.Staff;

public interface StaffServices {
	
	public ArrayList<Staff> getAllStaff();
	
	public Staff getStaff(Long id);
	
	public Staff getStaffByUsername(String username);
	
	public Staff getStaffByEmail(String email);
	
	public Staff addStaff(Staff staff);
	
	public Staff updateStaff(Long id, Staff staff);
	
	public void deleteStaff(Long id);
}
