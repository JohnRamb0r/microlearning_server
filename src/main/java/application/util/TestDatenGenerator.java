package application.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import application.entities.Abschnitt;
import application.entities.Lehrende;
import application.entities.Lerneinheit;
import application.repos.LerneinheitRepository;

@Component
public class TestDatenGenerator {

	@Autowired
	LerneinheitRepository lerneinheitRepository;
	
	public void generateTestData(){
		Lerneinheit l = new Lerneinheit();
		
		Lehrende lehrende = new Lehrende();
		lehrende.setBenutzername("Herr Mueller");
		lehrende.setPasswort("passwort");
		l.setLehrende(lehrende);
		
		List<Abschnitt> abschnittListe = new ArrayList<Abschnitt>();
		Abschnitt a = new Abschnitt();
		a.setInhalt("asdf");
		a.setMedia(null);
		a.setReihenfolge(1);
		a.setWissensueberpruefung(null);
		abschnittListe.add(a);
		
		Abschnitt a2 = new Abschnitt();
		a2.setInhalt("fdsa");
		a2.setMedia(null);
		a2.setReihenfolge(2);
		a2.setWissensueberpruefung(null);
		abschnittListe.add(a2);
		l.setAbschnitte(abschnittListe);
		
		l.setBeschreibung("Beschreibung ASDF");
		l.setTitel("Das ist ein Titel");
		
//		Lerneinheit l2 = new Lerneinheit();
//		l2.setAbschnitte(null);
//		l2.setBeschreibung(null);
//		l2.setTitel(null);
//		l2.setLehrende(lehrende);
		
		lerneinheitRepository.save(l);
		//lerneinheitRepository.save(l2);
	}
}
