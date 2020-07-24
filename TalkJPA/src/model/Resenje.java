package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the resenje database table.
 * 
 */
@Entity
@NamedQuery(name="Resenje.findAll", query="SELECT r FROM Resenje r")
public class Resenje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idResenje;

	private String tekst;

	//bi-directional many-to-one association to Pitanje
	@ManyToOne
	private Pitanje pitanje;

	public Resenje() {
	}

	public int getIdResenje() {
		return this.idResenje;
	}

	public void setIdResenje(int idResenje) {
		this.idResenje = idResenje;
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

}