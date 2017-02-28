package tmnt.isa.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tmnt.isa.project.model.Guest;
import tmnt.isa.project.model.LoginUser;
import tmnt.isa.project.model.RestaurantManager;
import tmnt.isa.project.model.Staff;
import tmnt.isa.project.model.Supplier;
import tmnt.isa.project.model.SystemManager;
import tmnt.isa.project.services.GuestServices;
import tmnt.isa.project.services.RestaurantManagerServices;
import tmnt.isa.project.services.StaffServices;
import tmnt.isa.project.services.SupplierServices;
import tmnt.isa.project.services.SystemManagerServices;

@Service
public class SecurityServicesImpl implements SecurityServices {
	
	@Autowired
	private GuestServices guestServices;
	
	@Autowired
	private SystemManagerServices systemManagerServices;
	
	@Autowired
	private RestaurantManagerServices restaurantManagerServices;
	
	@Autowired
	private StaffServices staffServices;
	
	@Autowired
	private SupplierServices supplierServices;
	
	@Override
	public LoginUser login(String username, String password) {
		Guest guest = guestServices.getGuestByUsername(username);
		SystemManager systemManager = systemManagerServices.getSystemManagerByUsername(username);
		RestaurantManager restaurantManager = restaurantManagerServices.getRestaurantManagerByUsername(username);
		Staff staff = staffServices.getStaffByUsername(username);
		Supplier supplier = supplierServices.getSupplierByUsername(username);
		
		if(guest != null && guest.getPassword().equals(password)) {
			return new LoginUser(guest, "guest");
		} else if(systemManager != null && systemManager.getPassword().equals(password)) {
			return new LoginUser(systemManager, "systemManager");
		} else if(restaurantManager != null && restaurantManager.getPassword().equals(password)) {
			return new LoginUser(restaurantManager, "restaurantManager");
		} else if(staff != null && staff.getPassword().equals(password)) {
			return new LoginUser(staff, "staff");
		} else if(supplier != null && supplier.getPassword().equals(password)) {
			return new LoginUser(supplier, "supplier");
		}
		
		return null;
	}
	
	@Override
	public boolean validations(String username, String email) {
		Guest guestU = guestServices.getGuestByUsername(username);
		SystemManager systemManagerU = systemManagerServices.getSystemManagerByUsername(username);
		RestaurantManager restaurantManagerU = restaurantManagerServices.getRestaurantManagerByUsername(username);
		Staff staffU = staffServices.getStaffByUsername(username);
		Supplier supplierU = supplierServices.getSupplierByUsername(username);
		
		Guest guestE = guestServices.getGuestByEmail(email);
		SystemManager systemManagerE = systemManagerServices.getSystemManagerByEmail(email);
		RestaurantManager restaurantManagerE = restaurantManagerServices.getRestaurantManagerByEmail(email);
		Staff staffE = staffServices.getStaffByEmail(email);
		Supplier supplierE = supplierServices.getSupplierByEmail(email);
		
		if(guestU == null && guestE == null && systemManagerU == null && systemManagerE == null && 
				restaurantManagerU == null && restaurantManagerE == null && staffU == null && staffE == null &&
				supplierU == null && supplierE == null) {
			System.out.println("true");
			return true;
		}
		
		System.out.println("false");
		return false;
	}
	
	@Override
	public boolean validationsU(String oldUsername, String oldEmail, String newUsername, String newEmail) {
		if(oldUsername.equals(newUsername) && oldEmail.equals(newEmail)) {
			return true;
		} else if(oldUsername.equals(newUsername)) {
			Guest guestE = guestServices.getGuestByEmail(newEmail);
			SystemManager systemManagerE = systemManagerServices.getSystemManagerByEmail(newEmail);
			RestaurantManager restaurantManagerE = restaurantManagerServices.getRestaurantManagerByEmail(newEmail);
			Staff staffE = staffServices.getStaffByEmail(newEmail);
			Supplier supplierE = supplierServices.getSupplierByEmail(newEmail);
			
			if(guestE == null && systemManagerE == null && restaurantManagerE == null && 
					staffE == null && supplierE == null) {
				System.out.println("true");
				return true;
			} else {
				return false;
			}
		} else if (oldEmail.equals(newEmail)) {
			Guest guestU = guestServices.getGuestByUsername(newUsername);
			SystemManager systemManagerU = systemManagerServices.getSystemManagerByUsername(newUsername);
			RestaurantManager restaurantManagerU = restaurantManagerServices.getRestaurantManagerByUsername(newUsername);
			Staff staffU = staffServices.getStaffByUsername(newUsername);
			Supplier supplierU = supplierServices.getSupplierByUsername(newUsername);
			
			if(guestU == null && systemManagerU == null && restaurantManagerU == null && 
					staffU == null && supplierU == null) {
				System.out.println("true");
				return true;
			} else {
				return false;
			}
		} else if(!oldUsername.equals(newUsername) && !oldEmail.equals(newEmail)) {
			Guest guestU = guestServices.getGuestByUsername(newUsername);
			SystemManager systemManagerU = systemManagerServices.getSystemManagerByUsername(newUsername);
			RestaurantManager restaurantManagerU = restaurantManagerServices.getRestaurantManagerByUsername(newUsername);
			Staff staffU = staffServices.getStaffByUsername(newUsername);
			Supplier supplierU = supplierServices.getSupplierByUsername(newUsername);
			
			Guest guestE = guestServices.getGuestByEmail(newEmail);
			SystemManager systemManagerE = systemManagerServices.getSystemManagerByEmail(newEmail);
			RestaurantManager restaurantManagerE = restaurantManagerServices.getRestaurantManagerByEmail(newEmail);
			Staff staffE = staffServices.getStaffByEmail(newEmail);
			Supplier supplierE = supplierServices.getSupplierByEmail(newEmail);
			
			if(guestU == null && guestE == null && systemManagerU == null && systemManagerE == null && 
					restaurantManagerU == null && restaurantManagerE == null && staffU == null && staffE == null &&
					supplierU == null && supplierE == null) {
				System.out.println("true");
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}

	@Override
	public void logout() {
		
	}
}
