package com.example.talk.security;

import java.util.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import model.*;

public class UserDetailsImpl implements UserDetails {	
	 
	private static final long serialVersionUID = 1L;
	private String username;
	 private String password;
	 private Uloga uloga;
	 
	 public UserDetailsImpl(Korisnik k) {
		 this.username = k.getKorisnickoIme();
		 this.password = k.getLozinka();
		 this.uloga = k.getUloga();
	 }
	
	 @Override
	 public Collection<SimpleGrantedAuthority> getAuthorities() {
		 Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + uloga.getNaziv()));
			return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}
	

}
