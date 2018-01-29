package application.entities;

public class MultipleChoice extends Wissensueberpruefung{

	
	private boolean istMehrfachauswahlZulaessig;
	
	// Gibt die Möglichkeit auf 0 oder < 0 richtige Antwortmöglichkeiten
	private boolean istRichtigeAntwortauswahlVorhanden;
	
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
