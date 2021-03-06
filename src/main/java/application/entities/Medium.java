package application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medium {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	// Mediatyp zB Video, Audio, Bild
	private String typ;
	@Column(columnDefinition="text")
	private String dateiname;

	//String zum Verzeichnispfad oder beim Senden ist es noch ein Base64ImageString
	@Column(columnDefinition="text")
	private String datei;
	@Column(columnDefinition="text")
	private String beschreibung;
	private int reihenfolge;
	
	public Medium(){
		
	}
	
	
	public Medium(String dateiname, String datei, int reihenfolge) {
		super();
		this.dateiname = dateiname;
		this.datei = datei;
		this.reihenfolge = reihenfolge;
	}
	
	public Medium(String dateiname, String datei, String beschreibung){
		super();
		this.typ="Bild";
		this.dateiname = dateiname;
		this.datei = datei;
		this.beschreibung = beschreibung;
		this.reihenfolge = -1;
	}
	
	public int getReihenfolge() {
		return reihenfolge;
	}
	public void setReihenfolge(int reihenfolge) {
		this.reihenfolge = reihenfolge;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDateiname() {
		return dateiname;
	}
	public void setDateiname(String dateiname) {
		this.dateiname = dateiname;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public String getDatei() {
		return datei;
	}
	public void setDatei(String datei) {
		this.datei = datei;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	
}
