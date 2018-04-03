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
import application.entities.Medium;
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
		a.setInhalt("asadsfadsfadsfasfasdfadsfadsfdf");
		a.setTitel("Sehr schön!");
		List<Medium> media = new ArrayList<Medium>();
		Medium med = new Medium("8.jpg", "/home/john-ramb0r/Bilder/8.jpg", "Ein sehr schönes Bild");
		
		media.add(med);
	    a.setMedia(media);
		a.setReihenfolge(1);
		abschnittListe.add(a);
		
		Abschnitt a2 = new Abschnitt();
		a2.setInhalt("fdsa");
		a2.setTitel("Sehr schön! 2");
		a2.setMedia(null);
		a2.setReihenfolge(2);
		abschnittListe.add(a2);
		l.setAbschnitte(abschnittListe);
		
		Abschnitt a3 = new Abschnitt();
		a3.setInhalt("fafadsfafadfadsdsa");
		a3.setTitel("Schauens mal nach oben!");
		a3.setMedia(null);
		a3.setReihenfolge(6);
		abschnittListe.add(a3);
		l.setAbschnitte(abschnittListe);
		
		List<MultipleChoice> mcListe = new ArrayList<MultipleChoice>();
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
		
		mcListe.add(m);
		
		List<Lueckentext> ltListe = new ArrayList<Lueckentext>();
		Lueckentext lText = new Lueckentext();
		lText.setAufgabenstellung("Vervollständigen Sie bitte die leeren Felder");
		lText.setErgaenzungstext("Asdf asdf");
		lText.setReihenfolge(4);
		lText.setSchwierigkeit(1);
		lText.setText("asdf asdf [[asdf]] asdf wwerwrw wrw wer[[sdfa]]");
		
		ltListe.add(lText);
		
		List<Erklaerbild> ebListe = new ArrayList<Erklaerbild>();
		Erklaerbild e = new Erklaerbild("8.jpg", "/home/john-ramb0r/da/8.jpg", "Ein sehr schönes Bild");
		
		e.setAntworten(antworten);
		e.setAufgabenstellung("Was ist die richtige Antwort auf dem Bild?");
		e.setErgaenzungstext("Geben Sie die richtige Antwort ein - es stimmt nur eine");
		e.setReihenfolge(5);
		e.setSchwierigkeit(3);
		
		ebListe.add(e);
		
		l.setMultipleChoices(mcListe);
		l.setLueckenTexte(ltListe);
		l.setErklaerBilder(ebListe);
		
		
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
