package application.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.entities.Abschnitt;
import application.entities.Erklaerbild;
import application.entities.Lehrende;
import application.entities.Lerneinheit;
import application.entities.Medium;
import application.repos.LehrendeRepository;
import application.repos.LerneinheitRepository;
import application.util.FolderFunctions;
import application.util.UtilBase64Image;


@RestController
@RequestMapping("/Lerneinheit")
public class LerneinheitController {
	
	@Autowired
	LerneinheitRepository lerneinheitRepository;
	

	@Autowired
	LehrendeRepository lehrendeRepository;
	
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
	 * Hinzufügen einer Lerneinheit.
	 * @param l (Lerneinheit)
	 * @return -
	 */
	@RequestMapping(value="/add/{id}", method=RequestMethod.POST, produces = "application/json")
	public Lerneinheit addLerneinheitByLehrendeID(@PathVariable("id") String id, @RequestBody Lerneinheit l){
		
		try{
			
			
		}catch(Exception e){
			
		}
		
		try{
			
			List<Abschnitt> abschnitte = l.getAbschnitte();
			
			for(Abschnitt a : abschnitte){
				
				//Für den Anfang, gibt es nur eine Bilddatei, daher get(0)
				String[] base64String = a.getMedia().get(0).getDatei().split(",");
				String dateiname = a.getMedia().get(0).getDateiname();
				String lerneinheitName = l.getTitel();
				String fullPath = FolderFunctions.getFullPath(lerneinheitName);
				String fullPathWithData = fullPath + dateiname;
				
				FolderFunctions.createFolder(lerneinheitName);
				
				UtilBase64Image.decoder(base64String[1], fullPathWithData);
				
				Medium m = a.getMedia().get(0);
				m.setDatei(fullPathWithData);
				
				List<Medium> mList = new ArrayList<Medium>();
				mList.add(m);
				
				a.setMedia(mList);
			}
			

			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		try{
			
			List<Erklaerbild> erklaerBilder = l.getErklaerBilder();
			
			System.out.println(l.getErklaerBilder().get(0).getMedia().getDatei());
			
			for(Erklaerbild e : erklaerBilder){
				
				//Für den Anfang, gibt es nur eine Bilddatei
				String[] base64String = e.getMedia().getDatei().split(",");
				String dateiname = e.getMedia().getDateiname();
				String lerneinheitName = l.getTitel();
				String fullPath = FolderFunctions.getFullPath(lerneinheitName);
				String fullPathWithData = fullPath + dateiname;
				
				FolderFunctions.createFolder(lerneinheitName);
				
				UtilBase64Image.decoder(base64String[1], fullPathWithData);
				
				Medium m = e.getMedia();
				m.setDatei(fullPathWithData);
				
				
				e.setMedia(m);
			}
			
			//List<Medium> mList = l.getErklaerBilder().get(0).getMedia();
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		Lehrende lehrende = lehrendeRepository.findOne(Long.parseLong(id));
		
		//
		
		l.setLehrende(lehrende);
		
		
		return lerneinheitRepository.save(l);
		//return new Lerneinheit();
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
