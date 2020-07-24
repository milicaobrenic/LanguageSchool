package com.example.talk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import model.Resenje;

public interface ResenjeRepository extends JpaRepository<Resenje, Integer> {

	@Query("select r from Resenje r where r.pitanje.idPitanje = :idPitanje")
	public List<Resenje> findResenjePitanja(@Param("idPitanje")Integer idPitanje);
	
}
