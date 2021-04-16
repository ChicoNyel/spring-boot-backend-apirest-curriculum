package springbootbackendapirestcurriculum.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootbackendapirestcurriculum.models.entity.Persona;
@Repository
public interface IPersonaDao extends CrudRepository<Persona, Long>{

	@Query("SELECT p FROM Persona p WHERE p.usuario.username=?1")
	public Persona findByUsername(String username);
	
}
