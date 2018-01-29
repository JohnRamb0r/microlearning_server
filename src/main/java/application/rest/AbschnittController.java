package application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import application.entities.Abschnitt;
import application.repos.AbschnittRepository;

@RestController
@RequestMapping("/abschnitt")
public class AbschnittController {
	
	@Autowired
	AbschnittRepository abschnittRepository;

	@RequestMapping("/{id}")
	public void editAbschnitt(@PathVariable("id") String id, Abschnitt a){
		Abschnitt result = abschnittRepository.findOne(Long.parseLong(id));
		
		result.setInhalt(a.getInhalt());
		result.setMedia(a.getMedia());
		result.setReihenfolge(a.getReihenfolge());
		
		abschnittRepository.save(a);
	}
	
}
