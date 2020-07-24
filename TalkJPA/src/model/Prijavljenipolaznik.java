package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prijavljenipolaznik database table.
 * 
 */
@Entity
@NamedQuery(name="Prijavljenipolaznik.findAll", query="SELECT p FROM Prijavljenipolaznik p")
public class Prijavljenipolaznik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPrijavljeniPolaznik;

	private String ime;

	private String prezime;

	private String username;

	//bi-directional many-to-many association to Kurs
	@ManyToMany
	@JoinTable(
		name="prijavljenipolaznik_has_kurs"
		, joinColumns={
			@JoinColumn(name="PrijavljeniPolaznik_idPrijavljeniPolaznik")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Kurs_idKurs")
			}
		)
	private List<Kurs> kurs;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Test_idTest", referencedColumnName = "idTest")
	private Test test;

	public Prijavljenipolaznik() {
	}

	public int getIdPrijavljeniPolaznik() {
		return this.idPrijavljeniPolaznik;
	}

	public void setIdPrijavljeniPolaznik(int idPrijavljeniPolaznik) {
		this.idPrijavljeniPolaznik = idPrijavljeniPolaznik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Kurs> getKurs() {
		return this.kurs;
	}

	public void setKurs(List<Kurs> kurs) {
		this.kurs = kurs;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}