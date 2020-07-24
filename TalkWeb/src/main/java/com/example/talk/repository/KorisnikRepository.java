package com.example.talk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.*;

public interface KorisnikRepository extends JpaRepository<Korisnik,Integer> {

	public Korisnik findByKorisnickoIme(String username);
	
	boolean existsByKorisnickoIme(String username);
	
}
