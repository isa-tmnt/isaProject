//package tmnt.isa.project.security;
//
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.glassfish.jersey.internal.util.Base64;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import tmnt.isa.project.model.LoginUser;
//
////@Component
//public class SecurityAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
//	
//	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
//	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
//	
//	@Autowired
//	private SecurityServices securityServices;
//
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException, ServletException {
//		
//		String authToken = request.getHeader(AUTHORIZATION_HEADER_KEY);
//		System.out.println(authToken);
//		
//		authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
//		String decodedString = Base64.decodeAsString(authToken);
//		StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
//		String username = tokenizer.nextToken();
//		String password = tokenizer.nextToken();
//		System.err.println("no");
//		
//		LoginUser user = securityServices.login(username, password);
//		if(user != null) {
//			System.out.println("yes");
//			return;
//		}
//		
//		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//	}
//	
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		setRealmName("TMNT");
//		super.afterPropertiesSet();
//	}
//}
