package tmnt.isa.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tmnt.isa.project.model.LoginUser;

@RestController
public class SecurityController {
	
	@Autowired
	private SecurityServices securityServices;
	
	@RequestMapping(
			value = "/api/login",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginUser login(@RequestBody LoginUser user) {
		return securityServices.login(user.getUsername(), user.getPassword());
	}
}
