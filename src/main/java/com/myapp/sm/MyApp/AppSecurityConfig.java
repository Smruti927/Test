package com.myapp.sm.MyApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userdetailsservice; 
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		provider.setUserDetailsService(userdetailsservice);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		
		
		
		
		return provider; 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/logout-success").permitAll();
		
		super.configure(http);
	}
	
	

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> user=new ArrayList<>();
	 * user.add(User.withDefaultPasswordEncoder().username("smruti").password(
	 * "smruti").roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */
	
	

}
