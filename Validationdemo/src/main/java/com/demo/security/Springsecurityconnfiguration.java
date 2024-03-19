package com.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Springsecurityconnfiguration 
{

	
	@Bean
	public AuthenticationManager authmanager(HttpSecurity http) throws Exception
	{
		AuthenticationManagerBuilder auth=
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		auth.authenticationProvider(authenticationProvider());
		return auth.build();
		
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService());
		return provider;
	}
	
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails user = User.builder()
				.username("user1")
				.password(passwordEncoder().encode("secret1"))
				.roles("user")
				.build();
		
		UserDetails admin = User.builder()
				.username("admin1")
				.password(passwordEncoder().encode("secret2"))
				.roles("admin")
				.build();
		
		
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception
	{
		
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->auth
				.antMatchers("/createCredentials").hasRole("admin")
				.antMatchers("/secureapi").hasAnyRole("admin","user")
		        .antMatchers("/").permitAll());
		      //  .anyRequest.authenticated())
			//	.httpBasic(Customizer.withDefaults()));
		
		return http.build();
	}
	
	
}	
	
	
	
	
	













