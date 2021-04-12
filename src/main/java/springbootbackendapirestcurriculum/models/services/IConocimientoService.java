package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import springbootbackendapirestcurriculum.models.entity.Conocimiento;
import springbootbackendapirestcurriculum.models.entity.Tecnologia;

public interface IConocimientoService {

	public List<Conocimiento> findAll();
	
	public Conocimiento findById(Long id);
	
	public Conocimiento save(Conocimiento conocimiento);
	
	public void delete(Long id);
	
	public List<Tecnologia> findAllTecnologias();
	
}
