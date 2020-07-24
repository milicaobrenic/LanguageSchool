package com.example.talk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
 	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests().
	   antMatchers("/","/loginPage", "/register.jsp").permitAll().
	   antMatchers("/predavac/**").hasRole("PREDAVAC").
	   antMatchers("/polaznik/**").hasRole("POLAZNIK").
	   and().formLogin().
	   loginPage("/login.jsp").
	   loginProcessingUrl("/login").
	   defaultSuccessUrl("/index.jsp").and().
	   logout().logoutSuccessUrl("/login.jsp").and().
	   exceptionHandling().accessDeniedPage("/access_denied.jsp").
	   and().rememberMe().
	   and().csrf().disable();
	}



	

	
	

}