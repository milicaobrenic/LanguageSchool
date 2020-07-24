package com.example.talk.security;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.talk.repository.KorisnikRepository;

import model.*;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
 
    
    @Autowired
    private KorisnikRepository kr; 
    
    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Korisnik user = kr.findByKorisnickoIme(username);
    	if(user == null)
    		throw new UsernameNotFoundException("Username doesnt exist");
		UserDetailsImpl userDetails = new UserDetailsImpl(user);
		return userDetails;
		
    }
 
     
 


	
     
}

