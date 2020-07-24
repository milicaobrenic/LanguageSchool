package com.example.talk.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import com.example.talk.repository.KorisnikRepository;
import com.example.talk.repository.KursRepository;
import com.example.talk.repository.LekcijaRepository;
import com.example.talk.repository.OdgovorRepository;
import com.example.talk.repository.PitanjeRepository;
import com.example.talk.repository.PrijavljenipolaznikRepository;
import com.example.talk.repository.ResenjeRepository;
import com.example.talk.repository.TestRepository;

import model.Korisnik;
import model.Kurs;
import model.Lekcija;
import model.Odgovor;
import model.Pitanje;
import model.Prijavljenipolaznik;
import model.Resenje;
import model.Test;


@Controller
@RequestMapping(value="/polaznikController")
public class PolaznikController {
	@Autowired
	KursRepository kr;
	@Autowired
	TestRepository tr;
	@Autowired
	PrijavljenipolaznikRepository ppr;
	@Autowired
	KorisnikRepository kor;
	@Autowired
	LekcijaRepository lr;
	@Autowired
	PitanjeRepository pr;
	@Autowired
	OdgovorRepository or;
	@Autowired
	ResenjeRepository rr;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value="/getKurs", method = RequestMethod.GET)
	public String getKursevi(HttpServletRequest request) {
		List<Kurs> kursevi = kr.findAll();
		
		request.getSession().setAttribute("kursevi", kursevi);
		
		return "ocenaKursa";
	}
	
	@RequestMapping(value="/dodajOcenuKursu", method = RequestMethod.POST)
	public String dodajOcenuKursu(HttpServletRequest request, String ocenaKursa, Integer kursO, Date datumOcene) {
		try {
			Kurs k = kr.findById(kursO).get();
			k.setOcena(ocenaKursa);
			k.setDatumOcene(datumOcene);
			
			Kurs sacuvani = kr.save(k);
			request.getSession().setAttribute("sacuvani", sacuvani);
			
			String porukaK;
			if (sacuvani != null) {
				porukaK = "Uspesno dodata ocena!";
			}
			else {
				porukaK = "Greska!";
			}
			
			request.getSession().setAttribute("porukaK", porukaK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greska... Kurs nije pronadjen!", e);
		}
		return "ocenaKursa";
	}
	
	@RequestMapping(value="/getKurseviPrijava", method = RequestMethod.GET)
	public String getKurseviPrijava(HttpServletRequest request) {
		List<Kurs> kurseviP = kr.findAll();
		
		request.getSession().setAttribute("kurseviP", kurseviP);
		
		return "pregledKursevaTabela";
	}
	
	@RequestMapping(value="/savePolaznik", method = RequestMethod.POST)
	public String savePolaznik(HttpServletRequest request, Integer idKurs) {
		try {
			Kurs k = kr.findById(idKurs).get();
			List<Kurs> lista = new ArrayList<>();
			lista.add(k);
				
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalNameString = authentication.getName();
			
			Korisnik korisnik = kor.findByKorisnickoIme(currentPrincipalNameString);
			String ime = korisnik.getIme();
			String prezime = korisnik.getPrezime();
			String username = korisnik.getKorisnickoIme();
			Prijavljenipolaznik pol = new Prijavljenipolaznik();
			pol.setIme(ime);
			pol.setPrezime(prezime);
			pol.setUsername(username);
			pol.setKurs(lista);
				
			Prijavljenipolaznik sacuvani = ppr.save(pol);
			
			String porukaP;
			if (sacuvani != null) {
				porukaP = "Uspesno ste se prijavili na kurs!";
			}
			else {
				porukaP = "Greska!";
			}
			
			request.getSession().setAttribute("porukaP", porukaP);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "pregledKursevaTabela";			
	}
	
	@RequestMapping(value="/getKurseviPolaznik", method = RequestMethod.GET)
	public String getKurseviPolaznik(HttpServletRequest request) {
		try {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalNameString = authentication.getName();
		
		List<Prijavljenipolaznik> pp = ppr.findAllByUsername(currentPrincipalNameString);
		Prijavljenipolaznik pol=pp.get(0);
		Integer id = pol.getIdPrijavljeniPolaznik();
		List<Kurs> kurseviPol = kr.kurseviPolaznik(currentPrincipalNameString);
		
		String poruka = "";
		
		if(kurseviPol == null) 
			poruka="Niste prijavljeni ni na jedan kurs!";
		
			
		request.getSession().setAttribute("poruka", poruka);
		request.getSession().setAttribute("kurseviPol", kurseviPol);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "kurseviPolaznik";
	}
	
	@RequestMapping(value="/prikazLekcijaKursa", method = RequestMethod.GET)
	public String prikazLekcijaKursa(HttpServletRequest request, Integer idKurs) {
		
		List<Lekcija> lekcijeK = lr.sveLekcijeKursa(idKurs);
		
		request.getSession().setAttribute("lekcijaK", lekcijeK);
		
		
		return "kurseviPolaznik";
	}
	
	@RequestMapping(value="/prikazLekcije", method = RequestMethod.GET)
	public String prikazLekcije(HttpServletRequest request, HttpServletResponse response, Integer idLekcija){
		try {
			Lekcija l = lr.findById(idLekcija).get();
			
			String naslov = l.getNaslov();
			String tekst = l.getTekst();
			
			if(tekst != null) 
				l.setTekst(tekst);
				l.setNaslov(naslov);
				l.setTekst(tekst);
			
			request.getSession().setAttribute("lekcija", l);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "prikazLekcije";	
	}	
	
	@RequestMapping(value = "/prikazFajla", method = RequestMethod.GET)
	  public void showImage(Integer idLekcija, HttpServletResponse response, HttpServletRequest request) 
	          throws ServletException, IOException{

		Lekcija lekcija=lr.findById(idLekcija).get();
	        
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(lekcija.getFajl());


	    response.getOutputStream().close();
	 }
	
	
	@RequestMapping(value="/getKurseviUtisak", method = RequestMethod.GET)
	public String getKurseviUtisak(HttpServletRequest request) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentPrincipalNameString = authentication.getName();
			
			List<Prijavljenipolaznik> pp = ppr.findAllByUsername(currentPrincipalNameString);
			Prijavljenipolaznik pol=pp.get(0);
			Integer id = pol.getIdPrijavljeniPolaznik();
			List<Kurs> kurseviPol = kr.kurseviPolaznik(currentPrincipalNameString);
			
			String poruka = "";
			
			if(kurseviPol == null) 
				poruka="Niste prijavljeni ni na jedan kurs!";
			
				
			request.getSession().setAttribute("poruka", poruka);
			request.getSession().setAttribute("kurseviPol", kurseviPol);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "dodavanjeUtiska";
	}
	
	@RequestMapping(value = "/dodajUtisak", method = RequestMethod.POST)
	public String dodajUtisak(HttpServletRequest request, Integer idKurs, String utisak) {
		try {
			Kurs kurs = kr.findById(idKurs).get();
			kurs.setUtisak(utisak);
		

			Kurs sacuvani = (Kurs) kr.save(kurs);
			request.getSession().setAttribute("sacuvani", sacuvani);

			String porukaKurs;
			if (sacuvani != null) {
				porukaKurs = "Uspesno dodat utisak za izabrani kurs!";
			} else {
				porukaKurs = "Greska!";
			}

			request.getSession().setAttribute("porukaKurs", porukaKurs);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "dodavanjeUtiska";
	}
	

	
	@RequestMapping(value="/getTestove", method = RequestMethod.GET)
	public String getTestove(HttpServletRequest request) {
		List<Test> testoviPol=tr.findAll();
		
		request.getSession().setAttribute("testoviPol", testoviPol);
		
		return "polaganjeTesta";
	}
	

	
	@RequestMapping(value="/testDetalji", method = RequestMethod.POST)
	public String testdetalji(HttpServletRequest request, Integer idTestPol) {
		List<Pitanje> pitanja=pr.findPitanjaTesta(idTestPol);
		request.getSession().setAttribute("pitanjaT", pitanja);
		return "testDetalji";
	}
	
	@RequestMapping(value="/prihvatiOdgovoreTesta", method=RequestMethod.POST)
	public String prihvatiOdgovore(HttpServletRequest request, String opcije, String tekstOdg
			, String checkb1, String checkb2, String checkb3) {
		try {
			List<Pitanje> pitanja=(List<Pitanje>)request.getSession().getAttribute("pitanjaT");
			List<Odgovor> odgovori;
			for(Pitanje pit : pitanja) {
				odgovori=pit.getOdgovors();
				List<Odgovor> odgovoriProf=new ArrayList<>();
			for(Odgovor o:odgovori) {
				if(o.getOznakaPolaznik()==null) {
					odgovoriProf.add(o);
				}
			}
			request.getSession().setAttribute("odgovoriP", odgovoriProf);
			for(Odgovor odg:odgovoriProf) {
					Odgovor novi=new Odgovor();
					if(odg.getTekst()!=null) {
						novi.setTekst(tekstOdg);
					}else if(odg.getTekst()==null){
						if(opcije!=null) {
							novi.setOpcija1(odg.getOpcija1());
							if(opcije.equalsIgnoreCase(odg.getOpcija1())) {
								novi.setTacnostOpcije1("1");
								novi.setTacnostOpcije2("0");
								novi.setTacnostOpcije3("0");
							}
							novi.setOpcija2(odg.getOpcija2());
							if(opcije.equalsIgnoreCase(odg.getOpcija2())) {
								novi.setTacnostOpcije2("1");
								novi.setTacnostOpcije1("0");
								novi.setTacnostOpcije3("0");
				 			}
							novi.setOpcija3(odg.getOpcija3());
							if(opcije.equalsIgnoreCase(odg.getOpcija3())) {
								novi.setTacnostOpcije3("1");
								novi.setTacnostOpcije1("0");
								novi.setTacnostOpcije2("0");
							}
						}
						if(checkb1!=null || checkb2!=null || checkb3!=null ) {
							novi.setOpcija1(odg.getOpcija1());
							novi.setOpcija2(odg.getOpcija2());
							novi.setOpcija3(odg.getOpcija3());
							if(checkb1!=null && checkb2!=null && checkb3==null) {
								if(checkb1.equalsIgnoreCase(odg.getOpcija1()) && checkb2.equalsIgnoreCase(odg.getOpcija2())) {
									novi.setTacnostOpcije1("1");
									novi.setTacnostOpcije2("1");
									novi.setTacnostOpcije3("0");
								}
							}
							if(checkb1!=null && checkb3!=null && checkb2==null) {
								if(checkb1.equalsIgnoreCase(odg.getOpcija1()) && checkb3.equalsIgnoreCase(odg.getOpcija3())) {
									novi.setTacnostOpcije1("1");
									novi.setTacnostOpcije2("0");
									novi.setTacnostOpcije3("1");
								}
							}
							if(checkb2!=null && checkb3!=null && checkb1==null) {
								if(checkb2.equalsIgnoreCase(odg.getOpcija2()) && checkb3.equalsIgnoreCase(odg.getOpcija3())) {
									novi.setTacnostOpcije1("0");
									novi.setTacnostOpcije2("1");
									novi.setTacnostOpcije3("1");
								}
							}
							if(checkb1!=null) {
								if(checkb1.equalsIgnoreCase(odg.getOpcija1())) {
									novi.setTacnostOpcije1("1");
									novi.setTacnostOpcije2("0");
									novi.setTacnostOpcije3("0");
								}
							}
							if(checkb2!=null) {
								if(checkb2.equalsIgnoreCase(odg.getOpcija2())) {
									novi.setTacnostOpcije1("0");
									novi.setTacnostOpcije2("1");
									novi.setTacnostOpcije3("0");
								}
							}
							if(checkb3!=null) {
								if(checkb3.equalsIgnoreCase(odg.getOpcija3())) {
									novi.setTacnostOpcije1("0");
									novi.setTacnostOpcije2("0");
									novi.setTacnostOpcije3("1");
								}
							}
							if(checkb1!=null && checkb2!=null && checkb3!=null) {
								if(checkb2.equalsIgnoreCase(odg.getOpcija2()) && checkb3.equalsIgnoreCase(odg.getOpcija3()) && checkb1.equalsIgnoreCase(odg.getOpcija1())) {
									novi.setTacnostOpcije1("1");
									novi.setTacnostOpcije2("1");
									novi.setTacnostOpcije3("1");
								}
							}
						}
					}
					novi.setPitanje(odg.getPitanje());
					novi.setTest(odg.getTest());
					novi.setOznakaPolaznik("polaznik");
		
					String porukaPol=null;
					Odgovor sacuvan=or.save(novi);
					if(sacuvan!=null) {
						porukaPol="Odgovori za test koji ste polagali su uspesno sacuvani!";
					}else {
						porukaPol="Odgovori nisu sacuvani!";
					}
					
					request.getSession().setAttribute("porukaPol", porukaPol);
				}
			}
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "prihvaceniOdgovoriTesta";
	}

	@RequestMapping(value="/prikazPolozenihKurseva", method = RequestMethod.GET)
	public String prikazPolozenihKurseva(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalNameString = authentication.getName();
		
		try {
			List<Prijavljenipolaznik> pp = ppr.findAllByUsername(currentPrincipalNameString);
			Prijavljenipolaznik polaznik = pp.get(0);
			Integer id = polaznik.getIdPrijavljeniPolaznik();
					
			List<Test> testoviPolaznika = tr.findSviTestoviPolaznika(id);
			
			List<Kurs> kursevi = new ArrayList<Kurs>();
			List<Test> polozeniTestovi = new ArrayList<>();
			
			for (Test t : testoviPolaznika) {
				int poeni = Integer.parseInt(t.getOsvojeniPoeni());
				if (poeni > (t.getBrojPoena()/2)) {
					polozeniTestovi.add(t);
				}
			}
			
			for (Test t : polozeniTestovi) {
				Kurs kurs = t.getKur();
				kursevi.add(kurs);
			}
			
			request.getSession().setAttribute("kursevi", kursevi);
			request.getSession().setAttribute("polaznik", polaznik);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greska... Kurs nije pronadjen!", e);
		}
		
		return "PregledPolozenihKurseva";
	}
}