package springbootbackendapirestcurriculum.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootbackendapirestcurriculum.models.entity.Estudio;

@Repository
public interface IEstudioDao extends CrudRepository<Estudio, Long>{

}
