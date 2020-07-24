package com.example.talk.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Kurs;

public interface KursRepository extends JpaRepository<Kurs, Integer>{
	
	public Kurs findByNaziv(String naziv);
	
	@Query("select k from Kurs k inner join k.prijavljenipolazniks p where p.username like :username")
	public List<Kurs> kurseviPolaznik(@Param("username") String username);
	
	@Query("select k from Kurs k inner join k.prijavljenipolazniks p where p.idPrijavljeniPolaznik = :idPrijavljeniPolaznik")
	public List<Kurs> findKursPolaznika(@Param("idPrijavljeniPolaznik")Integer idPrijavljeniPolaznik);

	@Query("select k from Kurs k where k.datumOcene >= :d1 and k.datumOcene <= :d2")
	public List<Kurs> kurseviOcenaDatum(@Param("d1") Date d1, @Param("d2") Date d2);
}
