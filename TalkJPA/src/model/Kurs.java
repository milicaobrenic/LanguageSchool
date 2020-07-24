package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the kurs database table.
 * 
 */
@Entity
@NamedQuery(name="Kurs.findAll", query="SELECT k FROM Kurs k")
public class Kurs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKurs;

	@Temporal(TemporalType.DATE)
	private Date datumOcene;

	private String komentar;

	private String naziv;

	private String ocekivaniIshod;

	private String ocena;

	private String opis;

	private String utisak;

	//bi-directional many-to-many association to Korisnik
	@ManyToMany
	@JoinTable(
		name="ima"
		, joinColumns={
			@JoinColumn(name="Kurs_idKurs")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Korsinik_idKorsinik")
			}
		)
	private List<Korisnik> korisniks;

	//bi-directional many-to-one association to Lekcija
	@OneToMany(mappedBy="kur")
	private List<Lekcija> lekcijas;

	//bi-directional many-to-many association to Prijavljenipolaznik
	@ManyToMany(mappedBy="kurs")
	private List<Prijavljenipolaznik> prijavljenipolazniks;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="kur")
	private List<Test> tests;

	public Kurs() {
	}

	public int getIdKurs() {
		return this.idKurs;
	}

	public void setIdKurs(int idKurs) {
		this.idKurs = idKurs;
	}

	public Date getDatumOcene() {
		return this.datumOcene;
	}

	public void setDatumOcene(Date datumOcene) {
		this.datumOcene = datumOcene;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOcekivaniIshod() {
		return this.ocekivaniIshod;
	}

	public void setOcekivaniIshod(String ocekivaniIshod) {
		this.ocekivaniIshod = ocekivaniIshod;
	}

	public String getOcena() {
		return this.ocena;
	}

	public void setOcena(String ocena) {
		this.ocena = ocena;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getUtisak() {
		return this.utisak;
	}

	public void setUtisak(String utisak) {
		this.utisak = utisak;
	}

	public List<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(List<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public List<Lekcija> getLekcijas() {
		return this.lekcijas;
	}

	public void setLekcijas(List<Lekcija> lekcijas) {
		this.lekcijas = lekcijas;
	}

	public Lekcija addLekcija(Lekcija lekcija) {
		getLekcijas().add(lekcija);
		lekcija.setKur(this);

		return lekcija;
	}

	public Lekcija removeLekcija(Lekcija lekcija) {
		getLekcijas().remove(lekcija);
		lekcija.setKur(null);

		return lekcija;
	}

	public List<Prijavljenipolaznik> getPrijavljenipolazniks() {
		return this.prijavljenipolazniks;
	}

	public void setPrijavljenipolazniks(List<Prijavljenipolaznik> prijavljenipolazniks) {
		this.prijavljenipolazniks = prijavljenipolazniks;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setKur(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setKur(null);

		return test;
	}

}