package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the odgovor database table.
 * 
 */
@Entity
@NamedQuery(name="Odgovor.findAll", query="SELECT o FROM Odgovor o")
public class Odgovor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOdgovor;

	private String opcija1;

	private String opcija2;

	private String opcija3;

	private String oznakaPolaznik;

	private String tacnostOpcije1;

	private String tacnostOpcije2;

	private String tacnostOpcije3;

	private String tekst;

	//bi-directional many-to-one association to Pitanje
	@ManyToOne
	private Pitanje pitanje;

	//bi-directional many-to-one association to Test
	@ManyToOne
	private Test test;

	public Odgovor() {
	}

	public int getIdOdgovor() {
		return this.idOdgovor;
	}

	public void setIdOdgovor(int idOdgovor) {
		this.idOdgovor = idOdgovor;
	}

	public String getOpcija1() {
		return this.opcija1;
	}

	public void setOpcija1(String opcija1) {
		this.opcija1 = opcija1;
	}

	public String getOpcija2() {
		return this.opcija2;
	}

	public void setOpcija2(String opcija2) {
		this.opcija2 = opcija2;
	}

	public String getOpcija3() {
		return this.opcija3;
	}

	public void setOpcija3(String opcija3) {
		this.opcija3 = opcija3;
	}

	public String getOznakaPolaznik() {
		return this.oznakaPolaznik;
	}

	public void setOznakaPolaznik(String oznakaPolaznik) {
		this.oznakaPolaznik = oznakaPolaznik;
	}

	public String getTacnostOpcije1() {
		return this.tacnostOpcije1;
	}

	public void setTacnostOpcije1(String tacnostOpcije1) {
		this.tacnostOpcije1 = tacnostOpcije1;
	}

	public String getTacnostOpcije2() {
		return this.tacnostOpcije2;
	}

	public void setTacnostOpcije2(String tacnostOpcije2) {
		this.tacnostOpcije2 = tacnostOpcije2;
	}

	public String getTacnostOpcije3() {
		return this.tacnostOpcije3;
	}

	public void setTacnostOpcije3(String tacnostOpcije3) {
		this.tacnostOpcije3 = tacnostOpcije3;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Pitanje getPitanje() {
		return this.pitanje;
	}

	public void setPitanje(Pitanje pitanje) {
		this.pitanje = pitanje;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}