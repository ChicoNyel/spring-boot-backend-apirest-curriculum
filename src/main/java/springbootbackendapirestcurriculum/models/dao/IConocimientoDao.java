package springbootbackendapirestcurriculum.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootbackendapirestcurriculum.models.entity.Conocimiento;

@Repository
public interface IConocimientoDao extends CrudRepository<Conocimiento, Long>{

}
