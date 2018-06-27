package application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Lueckentext extends Wissensueberpruefung{
	
	@Column(columnDefinition="text")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
