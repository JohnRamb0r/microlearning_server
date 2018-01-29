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
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="LEHRENDE_ID")
	private Lehrende lehrende;

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

}