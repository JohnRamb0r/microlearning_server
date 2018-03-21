package application.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.entities.Lerneinheit;
import application.entities.Medium;
import application.repos.LerneinheitRepository;


@RestController
@RequestMapping("/Lerneinheit")
public class LerneinheitController {
	
	@Autowired
	LerneinheitRepository lerneinheitRepository;
	

	/**
	 * @param -
	 * @return Alle Lerneinheiten werden aus der Datenbank zurückgegeben.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public List<Lerneinheit> getAllLerneinheiten(){
		List<Lerneinheit> lerneinheiten = new ArrayList<Lerneinheit>();
		for(Lerneinheit l : lerneinheitRepository.findAll())
			lerneinheiten.add(l);
		
		return lerneinheiten;
	}

	/**
	 * @param id (String) des Lehrenden
	 * @return Alle Lerneinheiten des Lehrenden werden aus der Datenbank zurückgegeben.
	 */
	@RequestMapping(value="/lehrende/{id}", method=RequestMethod.GET)
	public List<Lerneinheit> getAllLerneinheitenByLehrendeID(@PathVariable("id") String id){
		
		
		return lerneinheitRepository.findByLehrende_id(Long.parseLong(id));
	}
	/**
	 * @param id (String) des Lehrenden
	 * @return Alle Medien des Lehrenden werden aus der Datenbank zurückgegeben.
	 */
//	@RequestMapping(value="/{id}/medium/", method=RequestMethod.GET)
//	public List<Medium> getAllMedienByLerneinheitID(@PathVariable("id") String id){
//		
//		return lerneinheitRepositiory.findBy
//	}
	
	/**
	 * Hinzufügen einer Lerneinheit.
	 * @param l (Lerneinheit)
	 * @return -
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Lerneinheit addLerneinheit(@RequestBody Lerneinheit l){
		
		System.out.println(l.getAbschnitte());
		return lerneinheitRepository.save(l);
	}
	
	/**
	 * Eine Lerneinheit wird aufgrund ihrer ID gelöscht.
	 * @param id (String) der Lerneinheit
	 * @return -.
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteLerneinheit(@PathVariable("id") String id){
		try{
			lerneinheitRepository.delete(Long.parseLong(id));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * Eine Lerneinheit wird editiert.
	 * @param 1. l (Lerneinheit), 2. id (String) der Lerneinheit
	 * @return -
	 */
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public void editLerneinheit(@RequestBody Lerneinheit l, @PathVariable("id") String id){
				
		Lerneinheit lerneinheit = lerneinheitRepository.findOne(Long.parseLong(id));
		//lerneinheit.setAbschnitte(l.getAbschnitte());
		lerneinheit.setBeschreibung(l.getBeschreibung());
		lerneinheit.setTitel(l.getTitel());
		
		lerneinheitRepository.save(lerneinheit);
	}
}
