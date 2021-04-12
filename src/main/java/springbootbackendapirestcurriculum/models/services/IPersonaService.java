package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import springbootbackendapirestcurriculum.models.entity.Persona;

public interface IPersonaService {

	public List<Persona> findAll();
	
	public Persona findById(Long id);
	
	public Persona save(Persona persona);
	
	public void delete(Long id);
	
}
