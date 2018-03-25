package application.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Erklaerbild extends Wissensueberpruefung{

	//Zur Zeit nur ein Medium möglich, aber in Zukunft sollen mehrere Bilder möglich sein.
	//Eager, weil es durch lazy zu spät geladen werden würden --> fehler!
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Medium media;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ERKLAERBILD_ID")
	private List<Antwort> antworten;
	
	public Erklaerbild(){
		
	}

	public Erklaerbild(String dateiname, String datei, String beschreibung) {
		super();
		this.media = new Medium(dateiname, datei, beschreibung);
	}
	
	public Medium getMedia() {
		return media;
	}

	public void setMedia(Medium media) {
		this.media = media;
	}

	public List<Antwort> getAntworten() {
		return antworten;
	}

	public void setAntworten(List<Antwort> antworten) {
		this.antworten = antworten;
	}
	
	
}
