package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import springbootbackendapirestcurriculum.models.entity.Estudio;

public interface IEstudioService {

	public List<Estudio> findAll();
	
	public Estudio findById(Long id);
	
	public Estudio save(Estudio estudio);
	
	public void delete(Long id);
	
}
