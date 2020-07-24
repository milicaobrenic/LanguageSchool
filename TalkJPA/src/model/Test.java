package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTest;

	private double brojPoena;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String naslov;

	private String osvojeniPoeni;

	//bi-directional many-to-one association to Odgovor
	@OneToMany(mappedBy="test")
	private List<Odgovor> odgovors;

	//bi-directional many-to-one association to Pitanje
	@OneToMany(mappedBy="test")
	private List<Pitanje> pitanjes;

	@OneToOne(mappedBy = "test")
	private Prijavljenipolaznik prijavljenipolaznik;

	//bi-directional many-to-one association to Kurs
	@ManyToOne
	@JoinColumn(name="Kurs_idKurs")
	private Kurs kur;

	public Test() {
	}

	public int getIdTest() {
		return this.idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public double getBrojPoena() {
		return this.brojPoena;
	}

	public void setBrojPoena(double brojPoena) {
		this.brojPoena = brojPoena;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOsvojeniPoeni() {
		return this.osvojeniPoeni;
	}

	public void setOsvojeniPoeni(String osvojeniPoeni) {
		this.osvojeniPoeni = osvojeniPoeni;
	}

	public List<Odgovor> getOdgovors() {
		return this.odgovors;
	}

	public void setOdgovors(List<Odgovor> odgovors) {
		this.odgovors = odgovors;
	}

	public Odgovor addOdgovor(Odgovor odgovor) {
		getOdgovors().add(odgovor);
		odgovor.setTest(this);

		return odgovor;
	}

	public Odgovor removeOdgovor(Odgovor odgovor) {
		getOdgovors().remove(odgovor);
		odgovor.setTest(null);

		return odgovor;
	}

	public List<Pitanje> getPitanjes() {
		return this.pitanjes;
	}

	public void setPitanjes(List<Pitanje> pitanjes) {
		this.pitanjes = pitanjes;
	}

	public Pitanje addPitanje(Pitanje pitanje) {
		getPitanjes().add(pitanje);
		pitanje.setTest(this);

		return pitanje;
	}

	public Pitanje removePitanje(Pitanje pitanje) {
		getPitanjes().remove(pitanje);
		pitanje.setTest(null);

		return pitanje;
	}

	public Prijavljenipolaznik getPrijavljenipolaznik() {
		return prijavljenipolaznik;
	}

	public void setPrijavljenipolaznik(Prijavljenipolaznik prijavljenipolaznik) {
		this.prijavljenipolaznik = prijavljenipolaznik;
	}

	public Kurs getKur() {
		return this.kur;
	}

	public void setKur(Kurs kur) {
		this.kur = kur;
	}

}