package tmnt.isa.project.model;

public class LoginUser {
	
	private UserDetails userDetails;
	private String role;
	private String username;
	private String password;
	
	public LoginUser() {}
	
	public LoginUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public LoginUser(UserDetails userDetails, String role) {
		super();
		this.userDetails = userDetails;
		this.role = role;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
