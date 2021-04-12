package springbootbackendapirestcurriculum.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootbackendapirestcurriculum.models.entity.Conocimiento;
import springbootbackendapirestcurriculum.models.entity.Tecnologia;

@Repository
public interface IConocimientoDao extends CrudRepository<Conocimiento, Long>{

	@Query("from Tecnologia")
	public List<Tecnologia> findAllTecnologias();
	
}
