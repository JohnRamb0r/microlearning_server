package application.entities;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class Erklaerbild extends Wissensueberpruefung{

	@OneToOne(fetch = FetchType.LAZY)
	private Medium media;

	public Erklaerbild(String dateiname, String datei, String beschreibung) {
		super();
		this.media = new Medium(dateiname, datei, beschreibung);
	}

	public Medium getMedium() {
		return media;
	}

	public void setMedium(Medium media) {
		this.media = media;
	}
	
	
}
