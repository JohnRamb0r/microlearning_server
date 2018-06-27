package application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import application.entities.Lehrende;
import application.repos.LehrendeRepository;


@RestController
@RequestMapping("/lehrende")
public class LehrendeController {
	
	@Autowired
	LehrendeRepository lehrendeRepository;
	
	/**
	 * Gibt alle den Benutzernamen eines spezifischen Lehrenden zurück.
	 * @param LehrendeID (String)
	 * @return Benutzername des Lehrenden. (String)
	 */
	@RequestMapping("/{id}")
	public String getLehrendeBenutzername(@PathVariable("id") String id){
		Lehrende lehrende = lehrendeRepository.findOne(Long.parseLong(id));
		System.out.println(lehrende.getBenutzername());
		return lehrende.getBenutzername();
	}

}
