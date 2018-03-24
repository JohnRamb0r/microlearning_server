package application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Antwort {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Boolean istRichtig;
	private String text;
	
	public Antwort(Boolean istRichtig, String text) {
		super();
		this.istRichtig = istRichtig;
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getIstRichtig() {
		return istRichtig;
	}
	public void setIstRichtig(Boolean istRichtig) {
		this.istRichtig = istRichtig;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
