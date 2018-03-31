package application.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Lerneinheit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titel;
	private String beschreibung;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="LERNEINHEIT_ID")
	private List<Abschnitt> abschnitte;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="LERNEINHEIT_ID")
	private List<Wissensueberpruefung> wissensueberpruefung;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="LERNEINHEIT_ID")
	private List<MultipleChoice> multipleChoices;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="LERNEINHEIT_ID")
	private List<Lueckentext> lueckenTexte;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="LERNEINHEIT_ID")
	private List<Erklaerbild> erklaerBilder;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="LEHRENDE_ID")
	private Lehrende lehrende;
	
	

	public List<MultipleChoice> getMultipleChoices() {
		return multipleChoices;
	}

	public void setMultipleChoices(List<MultipleChoice> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}

	public List<Lueckentext> getLueckenTexte() {
		return lueckenTexte;
	}

	public void setLueckenTexte(List<Lueckentext> lueckenTexte) {
		this.lueckenTexte = lueckenTexte;
	}

	public List<Erklaerbild> getErklaerBilder() {
		return erklaerBilder;
	}

	public void setErklaerBilder(List<Erklaerbild> erklaerBilder) {
		this.erklaerBilder = erklaerBilder;
	}

	public Lehrende getLehrende() {
		return lehrende;
	}

	public void setLehrende(Lehrende lehrende) {
		this.lehrende = lehrende;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public List<Abschnitt> getAbschnitte() {
		return abschnitte;
	}

	public void setAbschnitte(List<Abschnitt> abschnitte) {
		this.abschnitte = abschnitte;
	}
	
	public List<Wissensueberpruefung> getWissensueberpruefung() {
		return wissensueberpruefung;
	}

	public void setWissensueberpruefung(List<Wissensueberpruefung> wissensueberpruefung) {
		this.wissensueberpruefung = wissensueberpruefung;
	}

}
