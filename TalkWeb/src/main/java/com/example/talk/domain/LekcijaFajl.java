package com.example.talk.domain;

import org.springframework.web.multipart.MultipartFile;

import model.Kurs;

public class LekcijaFajl {
	
	private int idLekcija;
	private String naslov;
	private String tekst;
	private MultipartFile fajl;
	private Kurs kurs;
	
	public LekcijaFajl() {
		super();
	}

	public int getIdLekcija() {
		return idLekcija;
	}

	public void setIdLekcija(int idLekcija) {
		this.idLekcija = idLekcija;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public MultipartFile getFajl() {
		return fajl;
	}

	public void setFajl(MultipartFile fajl) {
		this.fajl = fajl;
	}

	public Kurs getKurs() {
		return kurs;
	}

	public void setKurs(Kurs kurs) {
		this.kurs = kurs;
	}
	
	

}
