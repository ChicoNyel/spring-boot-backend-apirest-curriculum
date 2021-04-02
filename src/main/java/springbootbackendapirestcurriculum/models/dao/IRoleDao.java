package springbootbackendapirestcurriculum.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootbackendapirestcurriculum.models.entity.Role;

@Repository
public interface IRoleDao extends CrudRepository<Role, Long>{

}
