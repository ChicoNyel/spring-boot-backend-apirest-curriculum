package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import springbootbackendapirestcurriculum.models.entity.Role;

public interface IRoleService {

	public List<Role> findAll();
	
	public Role findById(Long id);
	
	public Role save(Role role);
	
	public void delete(Long id);
	
}
