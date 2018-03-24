package application.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import application.entities.Abschnitt;
import application.entities.Antwort;
import application.entities.Erklaerbild;
import application.entities.Lehrende;
import application.entities.Lerneinheit;
import application.entities.Lueckentext;
import application.entities.MultipleChoice;
import application.entities.Wissensueberpruefung;
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
		
		List<Wissensueberpruefung> fragenListe = new ArrayList<Wissensueberpruefung>();
		MultipleChoice m = new MultipleChoice();
		m.setAufgabenstellung("5+5");
		m.setErgaenzungstext("Errechnen Sie die oben angeführte Gleichung!");
		m.setIstMehrfachauswahlZulaessig(false);
		m.setIstRichtigeAntwortauswahlVorhanden(true);
		m.setReihenfolge(3);
		m.setSchwierigkeit(2);
		ArrayList<Antwort> antworten = new ArrayList<Antwort>();
		Antwort a1 = new Antwort(true, "10");
		Antwort b1 = new Antwort(false, "5");
		Antwort c1 = new Antwort(false, "123");
		Antwort d1 = new Antwort(false, "5w3453q");
		antworten.add(a1);
		antworten.add(b1);
		antworten.add(c1);
		antworten.add(d1);
		m.setAntworten(antworten);
		
		fragenListe.add(m);
		
		Lueckentext lText = new Lueckentext();
		lText.setAufgabenstellung("Vervollständigen Sie bitte die leeren Felder");
		lText.setErgaenzungstext("Asdf asdf");
		lText.setReihenfolge(4);
		lText.setSchwierigkeit(1);
		lText.setText("asdf asdf [[asdf]] asdf wwerwrw wrw wer[[sdfa]]");
		
		fragenListe.add(lText);
		
		Erklaerbild e = new Erklaerbild("//Dokumente/d.png", "Schönes Bild", "Ein sehr schönes Bild");
		
		//e.setAufgabenstellung();
		
		l.setWissensueberpruefung(fragenListe);
		
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
