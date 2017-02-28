package tmnt.isa.project.security;

import tmnt.isa.project.model.LoginUser;

public interface SecurityServices {
	
	public LoginUser login(String username, String password);
	
	public boolean validations(String username, String email);
	
	public boolean validationsU(String oldUsername, String oldEmail, String newUsername, String newEmail);
	
	public void logout();
}
