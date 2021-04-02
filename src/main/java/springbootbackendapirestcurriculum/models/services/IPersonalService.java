package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import springbootbackendapirestcurriculum.models.entity.Personal;

public interface IPersonalService {

	public List<Personal> findAll();
	
	public Personal findById(Long id);
	
	public Personal save(Personal personal);
	
	public void delete(Long id);
	
}
