package springbootbackendapirestcurriculum.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootbackendapirestcurriculum.models.entity.Personal;

@Repository
public interface IPersonalDao extends CrudRepository<Personal, Long>{

}
