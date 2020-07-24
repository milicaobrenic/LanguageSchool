package com.example.talk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Kurs;
import model.Prijavljenipolaznik;
import model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {
	
	public Test findByNaslov(String naslov);
	
	@Query("select t from Test t where t.prijavljenipolaznik.idPrijavljeniPolaznik = :idPrijavljeniPolaznik")
	public Test findTestPolaznika(@Param("idPrijavljeniPolaznik")Integer idPrijavljeniPolaznik);
	
	@Query("select t from Test t where t.prijavljenipolaznik.idPrijavljeniPolaznik = :idPrijavljeniPolaznik")
	public List<Test> findSviTestoviPolaznika(@Param("idPrijavljeniPolaznik")Integer idPrijavljeniPolaznik);
}
