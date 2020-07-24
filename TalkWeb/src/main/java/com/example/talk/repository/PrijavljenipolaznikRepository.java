package com.example.talk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import model.Prijavljenipolaznik;


public interface PrijavljenipolaznikRepository extends JpaRepository<Prijavljenipolaznik, Integer>{
	
	public List<Prijavljenipolaznik> findAllByUsername(String username);
//	public List<Prijavljenipolaznik> findByTest(@Param("idTest")Integer idTest);
	}
