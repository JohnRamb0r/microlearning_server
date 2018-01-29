package application.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import application.entities.Lerneinheit;

public interface LerneinheitRepository extends CrudRepository<Lerneinheit,Long>{

	List<Lerneinheit> findByLehrende_id(long parseLong);



}
