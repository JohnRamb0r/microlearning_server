package application.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="wissenueberpruefung_type")
public class Wissensueberpruefung {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String aufgabenstellung;
	private String ergaenzungstext;
	/**
	 * schwierigkeitsgrad der wissensüberprüfung soll 1-3 sein
	 * 1 ist leicht, 2 mittel und 3 schwer.
	 */
	private int schwierigkeit;
	
	public String getAufgabenstellung() {
		return aufgabenstellung;
	}
	public void setAufgabenstellung(String aufgabenstellung) {
		this.aufgabenstellung = aufgabenstellung;
	}
	public String getErgaenzungstext() {
		return ergaenzungstext;
	}
	public void setErgaenzungstext(String ergaenzungstext) {
		this.ergaenzungstext = ergaenzungstext;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getSchwierigkeit() {
		return schwierigkeit;
	}
	public void setSchwierigkeit(int schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}
	
}