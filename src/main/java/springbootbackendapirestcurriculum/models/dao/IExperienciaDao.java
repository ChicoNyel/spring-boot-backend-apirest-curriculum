package springbootbackendapirestcurriculum.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootbackendapirestcurriculum.models.entity.Experiencia;

@Repository
public interface IExperienciaDao extends CrudRepository<Experiencia, Long>{

}
