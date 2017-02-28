//package tmnt.isa.project.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
////@Configuration
////@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private SecurityAuthenticationEntryPoint authenticationEntryPoint;
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.authorizeRequests().antMatchers("/api/guests/add").permitAll().anyRequest().authenticated().and()
////			.authorizeRequests().antMatchers("/api/**").authenticated().and()
////			.httpBasic().authenticationEntryPoint(authenticationEntryPoint)
////			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.authorizeRequests()
//			.antMatchers("/api/**").authenticated().and()
//		.httpBasic().authenticationEntryPoint(authenticationEntryPoint)
//		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//	}
//}
