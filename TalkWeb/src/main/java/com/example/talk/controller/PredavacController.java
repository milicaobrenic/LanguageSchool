package com.example.talk.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.talk.domain.LekcijaFajl;
import com.example.talk.repository.KursRepository;
import com.example.talk.repository.LekcijaRepository;
import com.example.talk.repository.OdgovorRepository;
import com.example.talk.repository.PitanjeRepository;
import com.example.talk.repository.PrijavljenipolaznikRepository;
import com.example.talk.repository.ResenjeRepository;
import com.example.talk.repository.TestRepository;

import model.Kurs;
import model.Lekcija;
import model.Odgovor;
import model.Pitanje;
import model.Prijavljenipolaznik;
import model.Test;
import model.Resenje;

@Controller
@RequestMapping(value="/predavacController")
public class PredavacController {
	
	@Autowired
	KursRepository kr;
	@Autowired
	LekcijaRepository lrt;
	@Autowired
	PitanjeRepository pr;
	@Autowired 
	TestRepository tr;
	@Autowired
	OdgovorRepository or;
	@Autowired
	PrijavljenipolaznikRepository ppr;
	@Autowired
	ResenjeRepository rr;
	
	@RequestMapping(value="/dodajKurs", method=RequestMethod.POST)
	public String dodajKurs(HttpServletRequest request, String naziv, String opis, String ishod, String komentar) {
		Kurs kurs = new Kurs();
		kurs.setNaziv(naziv);
		kurs.setOpis(opis);
		kurs.setOcekivaniIshod(ishod);
		kurs.setKomentar(komentar);
		Kurs sacuvaniKurs = kr.save(kurs);
		
		String poruka;
		if (sacuvaniKurs != null) {
			poruka = "Uspesno kreiran kurs!";
		}
		else {
			poruka = "Greska!";
		}
		
		request.getSession().setAttribute("poruka", poruka);
		return "dodavanjeKursa";
	}	
	
	
	@RequestMapping(value="/dodajLekcijuTekst", method=RequestMethod.POST)
	public String dodajLekcijuTekst(HttpServletRequest request, String naslovL, String tekstL, Integer idKurs) {
		try {
			Kurs k = kr.findById(idKurs).get();
			
			Lekcija lekcija = new Lekcija();
			lekcija.setNaslov(naslovL);
			lekcija.setTekst(tekstL);
			lekcija.setKur(k);
			Lekcija sacuvana = lrt.save(lekcija);
			request.getSession().setAttribute("lekcija", sacuvana);
			String porukaL;
			
			if(sacuvana != null) {
				porukaL = "Uspesno ste dodali novu lekciju!";
			} else {
				porukaL = "Greska!";
			}
			
			request.getSession().setAttribute("porukaL", porukaL);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "dodavanjeLekcijeTekst";
	}
	
	@RequestMapping(value="/getKursevi", method = RequestMethod.GET)
	public String getKursevi(HttpServletRequest request) {
		List<Kurs> kursevi = kr.findAll();
		
		request.getSession().setAttribute("kursevi", kursevi);
		
		return "dodavanjeLekcijeTekst";
	}
	
	@RequestMapping(value="/getSviKursevi", method = RequestMethod.GET)
	public String getSviKursevi(HttpServletRequest request) {
		List<Kurs> sviKursevi = kr.findAll();
		
		request.getSession().setAttribute("sviKursevi", sviKursevi);
		
		return "dodavanjeLekcijeFajl";
	}
	
	@RequestMapping(value="/dodajLekcijuFajlInit", method=RequestMethod.GET)
	public String initialize(Model m){
		m.addAttribute("lekcijaF", new LekcijaFajl());
		return "dodavanjeLekcijeFajl";
	}
	

	@RequestMapping(value="/dodajLekcijuFajl" , method=RequestMethod.POST)
	public String dodajLekcijuFajl(Model m, @ModelAttribute("lekcijaF") LekcijaFajl lekcijaFajl, HttpServletRequest request, String naslovF,
			String tekstF, String nazivKursaF) {
		MultipartFile file = lekcijaFajl.getFajl();
		if(null!=file) {
			String fileName = file.getOriginalFilename();
			String filePath;
			try {
				filePath = System.getProperty("user.dir");
				System.out.println("Putanja je "+filePath);
				File fileFile = new File(filePath, fileName);

				file.transferTo(fileFile);
				Lekcija l1=new Lekcija();
				l1.setNaslov(naslovF);
				l1.setTekst(tekstF);
				l1.setFajl(Files.readAllBytes(fileFile.toPath()));
				Kurs kursF=kr.findByNaziv(nazivKursaF);
				l1.setKur(kursF);
				Lekcija sacuvana = lrt.save(l1);
				request.getSession().setAttribute("lekcija", sacuvana);
				
				String porukaF;
				
				if(sacuvana != null) {
					porukaF = "Uspesno ste dodali novu lekciju!";
				} else {
					porukaF = "Greska!";
				}
				
				request.getSession().setAttribute("porukaF", porukaF);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "dodavanjeLekcijeFajl";
	}
	
	
	@RequestMapping(value="/getLekcije", method = RequestMethod.GET)
	public String getLekcije(HttpServletRequest request) {
		List<Lekcija> lekcije = lrt.findAll();
		
		request.getSession().setAttribute("lekcije", lekcije);
		
		return "prikazLekcijaTabela";
	}
	
	
	@RequestMapping(value="/getKurseviTest", method = RequestMethod.GET)
	public String getKurseviTest(HttpServletRequest request, Integer idKurs) {
		try {
			Kurs kurs = kr.findById(idKurs).get();
			
			request.getSession().setAttribute("kurs", kurs);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Greska! Kurs nije pronadjen.", e);
		}
		return "dodavanjeTesta";
	}
	
	@RequestMapping(value="/saveTest", method = RequestMethod.POST)
	public String saveTest(HttpServletRequest request,Integer brojPoena, String naslovT) {
		Kurs k = (Kurs) request.getSession().getAttribute("kurs");
		Test t = new Test();
		t.setBrojPoena(brojPoena);
		t.setKur(k);
		t.setNaslov(naslovT);
		Test dt = tr.save(t);
		request.getSession().setAttribute("dodajTest",dt);
		String porukaT;
		
		if(dt != null) {
			porukaT = "Uspesno ste dodali test!";
		} else {
		porukaT = "Greska!";
		}
	
		request.getSession().setAttribute("porukaT", porukaT);

		return "dodavanjeTesta";
	}
	
	@RequestMapping(value="/getTest", method = RequestMethod.GET)
	public String getTest(HttpServletRequest request) {
		List<Test> test = tr.findAll();
		
		request.getSession().setAttribute("test", test);
		
		return "dodavanjePitanja";
	}
	
	
	@RequestMapping(value="/dodajPitanja", method = RequestMethod.POST)
	public String dodajPitanja(HttpServletRequest request,String tekst,Integer idTest,String brojPoena) {
		try {
			Test t = tr.findById(idTest).get();
			
			Pitanje p = new Pitanje();
			
			p.setTekst(tekst);
			p.setTest(t);
			p.setBrojPoena(brojPoena);
			
			Pitanje pitanje = pr.save(p);
			request.getSession().setAttribute("pitanje",pitanje);
			String porukaPitanje;
			
			if(pitanje != null) {
				porukaPitanje = "Uspesno ste dodali novo pitanje!";
			} else {
				porukaPitanje = "Greska!";
			}
			
			request.getSession().setAttribute("porukaPitanje", porukaPitanje);
	
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "dodavanjePitanja";
	}
	
	@RequestMapping(value="/getPitanja", method = RequestMethod.GET)
	public String getPitanja(HttpServletRequest request) {
		List<Pitanje> pitanja = pr.findAll();
		
		request.getSession().setAttribute("pitanja", pitanja);
		
		return "dodavanjeOdgovoraTekst";
	}
	
	@RequestMapping(value="/dodajOdgovorTekst", method = RequestMethod.POST)
	public String dodajOdgovorTekst(HttpServletRequest request, String testIme, Integer idPitanje, String odgovorTekst) {	
		try {
			Test test = tr.findByNaslov(testIme);
			Pitanje pitanje = pr.findById(idPitanje).get();
			
			Odgovor odgovor = new Odgovor();
			odgovor.setTest(test);
			odgovor.setPitanje(pitanje);
			odgovor.setTekst(odgovorTekst);
			
			Odgovor odgovorSacuvan = or.save(odgovor);
			request.getSession().setAttribute("odgovorS", odgovorSacuvan);
			String porukaO;
			
			if (odgovorSacuvan != null) {
				porukaO = "Uspesno sacuvan odgovor!";
			}
			else {
				porukaO = "Greska pri cuvanju odgovora!";
			}
			
			request.getSession().setAttribute("porukaO", porukaO);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "dodavanjeOdgovoraTekst";
	}
	
	@RequestMapping(value="/getSvaPitanja", method = RequestMethod.GET)
	public String getSvaPitanja(HttpServletRequest request) {
		List<Pitanje> pitanjaO = pr.findAll();
		
		request.getSession().setAttribute("pitanjaO", pitanjaO);
		
		return "dodavanjeOdgovoraOpcije";
	}
	
	@RequestMapping(value="/dodajOdgovorOpcije", method=RequestMethod.POST)
	public String dodajOdgovorJednaOpcija(HttpServletRequest request, String testImeO,
			Integer idPitanjeO, String opcija1, String tacnostO1, String opcija2, String tacnostO2,
			String opcija3, String tacnostO3) {
		try {
			Test test = tr.findByNaslov(testImeO);
			Pitanje pitanje = pr.findById(idPitanjeO).get();
			
			Odgovor odgovor = new Odgovor();
			odgovor.setTest(test);
			odgovor.setPitanje(pitanje);
			odgovor.setOpcija1(opcija1);
			odgovor.setTacnostOpcije1(tacnostO1);
			odgovor.setOpcija2(opcija2);
			odgovor.setTacnostOpcije2(tacnostO2);
			odgovor.setOpcija3(opcija3);
			odgovor.setTacnostOpcije3(tacnostO3);
			
			Odgovor odgovorSacuvan = or.save(odgovor);
			request.getSession().setAttribute("odgovorO", odgovorSacuvan);
			String porukaO;
			
			if (odgovorSacuvan != null) {
				porukaO = "Uspesno sacuvan odgovor!";
			}
			else {
				porukaO = "Greska pri cuvanju odgovora!";
			}
			
			request.getSession().setAttribute("porukaO", porukaO);
		
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "dodavanjeOdgovoraOpcije";
	}
	
	
	@RequestMapping(value="/getSviPolaznici", method = RequestMethod.GET)
	public String getSviPolaznici(HttpServletRequest request) {
		List<Prijavljenipolaznik> polaznici = ppr.findAll();
		
		request.getSession().setAttribute("polaznici", polaznici);
		
		return "prikazPolaznika";
	}
	
	
	@RequestMapping(value="/getPolaznikovTest", method = RequestMethod.GET)
	public String getPolaznikovTest(HttpServletRequest request,Integer idPrijavljeniPolaznik){
		try {
			int osvojeniPoeni=0;	
			Test test=tr.findTestPolaznika(idPrijavljeniPolaznik);
			request.getSession().setAttribute("test", test);
			List<Pitanje> pitanjaTesta=test.getPitanjes();
			request.getSession().setAttribute("pitanjaTesta", pitanjaTesta);
			for(Pitanje pit : pitanjaTesta) {
				List<Odgovor> odgovoriTesta=pit.getOdgovors();
				List<Odgovor> odgovoriPolaznika=new ArrayList<>();
				for(Odgovor o: odgovoriTesta) {
					if(o.getOznakaPolaznik()!=null) {
						odgovoriPolaznika.add(o);
					}
				}
				
				List<Resenje> resenja=rr.findResenjePitanja(pit.getIdPitanje());
				Resenje r1 = null;
				Resenje r2 = null;
				Resenje r3 = null;
				if(resenja.size()==1) {
					r1=resenja.get(0);
				}else if(resenja.size()==2) {
					r1=resenja.get(0);
					r2=resenja.get(1);
				}else if(resenja.size()==3) {
					r1=resenja.get(0);
					r2=resenja.get(1);
					r3=resenja.get(2);
				}
				
				String poeni = pit.getBrojPoena();
				int poeniInt = Integer.parseInt(poeni);
				
				for(Odgovor odg:odgovoriPolaznika) {
						
					Odgovor unetOdg1=null;
					Odgovor unetOdg2=null;
					Odgovor unetOdg3=null;
					Odgovor tekstOdg=null;
					
						if(odg.getTekst()==null) {
							if(odg.getTacnostOpcije1().equalsIgnoreCase("1")) {
								unetOdg1=odg;
							}else if(odg.getTacnostOpcije2().equalsIgnoreCase("1")) {
								unetOdg2=odg;
							}else if(odg.getTacnostOpcije3().equalsIgnoreCase("1")) {
								unetOdg3=odg;
							}
							if(r1!=null && unetOdg1!=null) {
								if(r1.getTekst().equals(unetOdg1.getOpcija1())) {
										osvojeniPoeni+=poeniInt;
								}
							}
							else if(r2!=null  && unetOdg2!=null) {
								if(r2.getTekst().equals(unetOdg2.getOpcija2())) {
									osvojeniPoeni+=poeniInt;
								}
							}
							else if(r3!=null && unetOdg3!=null) {
								if(r3.getTekst().equals(unetOdg3.getOpcija3())) {
									osvojeniPoeni+=poeniInt;
								}
							}
							else if ((r1!=null && unetOdg1!=null) && (r2!=null  && unetOdg2!=null)) {
								if (r1.getTekst().equals(unetOdg1.getOpcija1()) && r2.getTekst().equals(unetOdg2.getOpcija2())) {
									osvojeniPoeni+=poeniInt;
								}
							}
							else if ((r1!=null && unetOdg1!=null) && (r3!=null  && unetOdg3!=null)) {
								if (r1.getTekst().equals(unetOdg1.getOpcija1()) && r3.getTekst().equals(unetOdg3.getOpcija3())) {
									osvojeniPoeni+=poeniInt;
								}
							}
							else if ((r2!=null && unetOdg2!=null) && (r3!=null  && unetOdg3!=null)) {
								if (r2.getTekst().equals(unetOdg2.getOpcija2()) && r3.getTekst().equals(unetOdg3.getOpcija3())) {
									osvojeniPoeni+=poeniInt;
								}
							}
							else if ((r1!=null && unetOdg1!=null) && (r3!=null  && unetOdg3!=null) && (r2!=null && unetOdg2!=null)) {
								if (r1.getTekst().equals(unetOdg1.getOpcija1()) && r3.getTekst().equals(unetOdg3.getOpcija3()) && r2.getTekst().equals(unetOdg2.getOpcija2())) {
									osvojeniPoeni+=poeniInt;
								}
							}
						}else {
							tekstOdg=odg;
							if (r1 != null && tekstOdg != null) {
								if (r1.getTekst().equalsIgnoreCase(tekstOdg.getTekst())) {
									osvojeniPoeni += poeniInt;
								}
							}
						}
					}
			}
			String suma=Integer.toString(osvojeniPoeni);
			test.setOsvojeniPoeni(suma);
			
			request.getSession().setAttribute("osvojeniPoeni", suma);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
		}
		return "prikazTesta";
	}
	
	@RequestMapping(value = "/getSvaPitanjaResenje" ,method = RequestMethod.GET)
	public String getResenje(HttpServletRequest request) {
		List <Pitanje> pitanja = pr.findAll();
		request.getSession().setAttribute("pitanja", pitanja);
		return "dodajResenje";
	}
	
	@RequestMapping(value = "/getDodajResenje" ,method = RequestMethod.POST)
		public String getDodajResenje(HttpServletRequest request,Integer idPitanja,String tekst) {
			try {
				Pitanje p = pr.findById(idPitanja).get();
				Resenje r = new Resenje();
				r.setPitanje(p);
				r.setTekst(tekst);
				Resenje resenje = rr.save(r);
				request.getSession().setAttribute("resenje", resenje);
				
				String porukaResenje;
				if (resenje != null) {
					porukaResenje = "Uspesno ste  dodali resenje pitanja!";
				}
				else {
					porukaResenje = "Greska!";
				}
				
				request.getSession().setAttribute("porukaResenje", porukaResenje);
			}catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doslo je do greske...", e);
			}
			return "dodajResenje";
	}
}
