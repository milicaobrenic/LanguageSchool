package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pitanje database table.
 * 
 */
@Entity
@NamedQuery(name="Pitanje.findAll", query="SELECT p FROM Pitanje p")
public class Pitanje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPitanje;

	private String brojPoena;

	private String tekst;

	//bi-directional many-to-one association to Odgovor
	@OneToMany(mappedBy="pitanje")
	private List<Odgovor> odgovors;

	//bi-directional many-to-one association to Test
	@ManyToOne
	private Test test;

	//bi-directional many-to-one association to Resenje
	@OneToMany(mappedBy="pitanje")
	private List<Resenje> resenjes;

	public Pitanje() {
	}

	public int getIdPitanje() {
		return this.idPitanje;
	}

	public void setIdPitanje(int idPitanje) {
		this.idPitanje = idPitanje;
	}

	public String getBrojPoena() {
		return this.brojPoena;
	}

	public void setBrojPoena(String brojPoena) {
		this.brojPoena = brojPoena;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public List<Odgovor> getOdgovors() {
		return this.odgovors;
	}

	public void setOdgovors(List<Odgovor> odgovors) {
		this.odgovors = odgovors;
	}

	public Odgovor addOdgovor(Odgovor odgovor) {
		getOdgovors().add(odgovor);
		odgovor.setPitanje(this);

		return odgovor;
	}

	public Odgovor removeOdgovor(Odgovor odgovor) {
		getOdgovors().remove(odgovor);
		odgovor.setPitanje(null);

		return odgovor;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Resenje> getResenjes() {
		return this.resenjes;
	}

	public void setResenjes(List<Resenje> resenjes) {
		this.resenjes = resenjes;
	}

	public Resenje addResenje(Resenje resenje) {
		getResenjes().add(resenje);
		resenje.setPitanje(this);

		return resenje;
	}

	public Resenje removeResenje(Resenje resenje) {
		getResenjes().remove(resenje);
		resenje.setPitanje(null);

		return resenje;
	}

}