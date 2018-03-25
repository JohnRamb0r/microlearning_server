package application.entities;

import javax.persistence.Entity;

@Entity
public class Lueckentext extends Wissensueberpruefung{
	
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
