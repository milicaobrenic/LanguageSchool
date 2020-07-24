package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lekcija database table.
 * 
 */
@Entity
@NamedQuery(name="Lekcija.findAll", query="SELECT l FROM Lekcija l")
public class Lekcija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLekcija;

	@Lob
	private byte[] fajl;

	private String naslov;

	private String tekst;

	//bi-directional many-to-one association to Kur
	@ManyToOne
	@JoinColumn(name="Kurs_idKurs")
	private Kurs kur;

	public Lekcija() {
	}

	public int getIdLekcija() {
		return this.idLekcija;
	}

	public void setIdLekcija(int idLekcija) {
		this.idLekcija = idLekcija;
	}

	public byte[] getFajl() {
		return this.fajl;
	}

	public void setFajl(byte[] fajl) {
		this.fajl = fajl;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Kurs getKur() {
		return this.kur;
	}

	public void setKur(Kurs kur) {
		this.kur = kur;
	}

}