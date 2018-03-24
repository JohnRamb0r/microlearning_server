package application.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class MultipleChoice extends Wissensueberpruefung{

	
	private boolean istMehrfachauswahlZulaessig;
	
	// Gibt die Möglichkeit auf 0 oder > 0 richtige Antwortmöglichkeiten
	private boolean istRichtigeAntwortauswahlVorhanden;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="MULTIPLECHOICE_ID")
	private ArrayList<Antwort> antworten = new ArrayList<Antwort>();
	
	public ArrayList<Antwort> getAntworten() {
		return antworten;
	}
	public void setAntworten(ArrayList<Antwort> antworten) {
		this.antworten = antworten;
	}
	public boolean isIstMehrfachauswahlZulaessig() {
		return istMehrfachauswahlZulaessig;
	}
	public void setIstMehrfachauswahlZulaessig(boolean istMehrfachauswahlZulaessig) {
		this.istMehrfachauswahlZulaessig = istMehrfachauswahlZulaessig;
	}
	public boolean isIstRichtigeAntwortauswahlVorhanden() {
		return istRichtigeAntwortauswahlVorhanden;
	}
	public void setIstRichtigeAntwortauswahlVorhanden(boolean istRichtigeAntwortauswahlVorhanden) {
		this.istRichtigeAntwortauswahlVorhanden = istRichtigeAntwortauswahlVorhanden;
	}
	
}
