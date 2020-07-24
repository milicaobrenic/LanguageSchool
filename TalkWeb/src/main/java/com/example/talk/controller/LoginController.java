package com.example.talk.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.talk.repository.KorisnikRepository;
import com.example.talk.repository.UlogaRepository;
import model.*;

@Controller
@RequestMapping(value="/lkontroler")

public class LoginController {
	
	@Autowired
	UlogaRepository ur;
	
	@Autowired
	KorisnikRepository kr;


	
	@ModelAttribute
	public void getRoles(Model model) {
		List<Uloga> roles=ur.findAll();
		model.addAttribute("roles", roles);
	}
	
	   @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	    public String loginPage() {
	    	return "login";
	    }
	   
	   @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String loginHello() {  
	    	return "hello";
	     
	    }
	 
	    @RequestMapping(value = "register", method = RequestMethod.POST)
		public String newUser(Korisnik k, Model model) {
	    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	     	k.setLozinka(passwordEncoder.encode(k.getLozinka()));
	     	k.setUloga(ur.findById(2).get());
	     	Korisnik sacuvani = kr.save(k);
			model.addAttribute("k", sacuvani);
			
			return "register";
			   
		}
	    
	    @RequestMapping(value="/pocetna", method = RequestMethod.GET)
	    public String getPocetnaStr (){
	       
	        return "pocetnaStr";
	    }
	
}
