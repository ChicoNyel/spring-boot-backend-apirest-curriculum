package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import springbootbackendapirestcurriculum.models.entity.Conocimiento;

public interface IConocimientoService {

	public List<Conocimiento> findAll();
	
	public Conocimiento findById(Long id);
	
	public Conocimiento save(Conocimiento conocimiento);
	
	public void delete(Long id);
	
}
