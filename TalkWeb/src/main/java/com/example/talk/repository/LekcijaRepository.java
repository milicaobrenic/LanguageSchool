package com.example.talk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import model.Lekcija;

public interface LekcijaRepository extends JpaRepository<Lekcija, Integer>{
	
	@Query("select l from Lekcija l where l.kur.idKurs = :idKurs")
	public List<Lekcija> sveLekcijeKursa(@Param("idKurs") Integer idKurs);

}
