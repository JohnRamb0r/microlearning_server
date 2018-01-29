package application.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Abschnitt {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String inhalt;
	private int reihenfolge;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="MEDIUM_ID")
	private List<Medium> media;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="WISSENSUEBERPRUEFUNG_ID")
	private List<Wissensueberpruefung> Wissensueberpruefung;
	
	
	public List<Wissensueberpruefung> getWissensueberpruefung() {
		return Wissensueberpruefung;
	}

	public void setWissensueberpruefung(List<Wissensueberpruefung> wissensueberpruefung) {
		Wissensueberpruefung = wissensueberpruefung;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public int getReihenfolge() {
		return reihenfolge;
	}

	public void setReihenfolge(int reihenfolge) {
		this.reihenfolge = reihenfolge;
	}

	public List<Medium> getMedia() {
		return media;
	}

	public void setMedia(List<Medium> media) {
		this.media = media;
	}

	
	
}
