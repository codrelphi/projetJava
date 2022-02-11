package com.test.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private DataSource dataSource;
	
	// ici, on a utilisé inMeMoryAuthentication
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = getBCryptPasswordEncoder();
		
		//auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN", "USER");
		//auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
		
		auth.inMemoryAuthentication().withUser("admin").password(bCryptPasswordEncoder.encode("1234")).roles("ADMIN", "USER");
		auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder.encode("1234")).roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder);
		
	}*/
	
	// ici, on a utilisé inMeMoryAuthentication
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = getBCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("1234"));
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as credentials, active as enabled from users where username=?")
			.authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
			.rolePrefix("ROLE_")
			.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		
		http.formLogin();
		http.authorizeHttpRequests().antMatchers("/hello", "/produits", "/save").hasRole("ADMIN");
		http.authorizeHttpRequests().antMatchers("/hello").hasRole("USER");
		http.exceptionHandling().accessDeniedPage("/403");
		
	}
	
	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
