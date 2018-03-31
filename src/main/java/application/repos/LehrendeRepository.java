package application.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import application.entities.Lehrende;
import application.entities.Lerneinheit;

public interface LehrendeRepository extends CrudRepository<Lehrende,Long>{

	
	//Lehrende findByLehrende_id(long parseLong);
}
