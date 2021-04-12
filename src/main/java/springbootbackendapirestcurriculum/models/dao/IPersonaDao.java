package springbootbackendapirestcurriculum.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootbackendapirestcurriculum.models.entity.Persona;

@Repository
public interface IPersonaDao extends CrudRepository<Persona, Long>{

}
