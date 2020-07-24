package com.example.talk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Pitanje;

public interface PitanjeRepository extends JpaRepository<Pitanje, Integer>{
	
	@Query("select p from Pitanje p where p.test.idTest = :idTest")
	public List<Pitanje> findPitanjaTesta(@Param("idTest")Integer idTest);

}
