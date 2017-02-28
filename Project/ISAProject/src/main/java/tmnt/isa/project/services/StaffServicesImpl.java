package tmnt.isa.project.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Staff;
import tmnt.isa.project.repository.StaffRepository;
import tmnt.isa.project.security.SecurityServices;

@Service
public class StaffServicesImpl implements StaffServices {
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private SecurityServices securityServices;
	
	@Override
	public ArrayList<Staff> getAllStaff() {
		ArrayList<Staff> staff = new ArrayList<Staff>();
		for(Staff st : staffRepository.findAll()) {
			staff.add(st);
		}
		
		return staff;
	}

	@Override
	public Staff getStaff(Long id) {
		Staff staff = staffRepository.findOne(id);
		if(staff != null) {
			return staff;
		}
		
		return null;
	}

	@Override
	public Staff getStaffByUsername(String username) {
		Staff staff = staffRepository.findByUsername(username);
		if(staff != null) {
			return staff;
		}
		
		return null;
	}
	
	@Override
	public Staff getStaffByEmail(String email) {
		Staff staff = staffRepository.findByEmail(email);
		if(staff != null) {
			return staff;
		}
		
		return null;
	}

	@Override
	public Staff addStaff(Staff staff) {
		boolean b = securityServices.validations(staff.getUsername(), staff.getEmail());
		
		if(b) {
			return staffRepository.save(staff);
		} else {
			return null;
		}
	}

	@Override
	public Staff updateStaff(Long id, Staff staff) {
		Staff s = staffRepository.findOne(id);
		if(s != null) {
			boolean b = securityServices.validationsU(s.getUsername(), s.getEmail(), 
					staff.getUsername(), staff.getEmail()
			);
			
			if(b) {
				return staffRepository.save(staff);
			} else {
				return null;
			}
		}
		
		return null;
	}

	@Override
	public void deleteStaff(Long id) {
		Staff staff = staffRepository.findOne(id);
		if(staff != null) {
			staffRepository.delete(id);
		}
	}
}
