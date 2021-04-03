package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springbootbackendapirestcurriculum.models.dao.IExperienciaDao;
import springbootbackendapirestcurriculum.models.entity.Experiencia;

@Service
public class ExperienciaServiceImpl implements IExperienciaService{

	@Autowired
	private IExperienciaDao experienciaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Experiencia> findAll() {
		return (List<Experiencia>) experienciaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Experiencia findById(Long id) {
		return experienciaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Experiencia save(Experiencia experiencia) {
		return experienciaDao.save(experiencia);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		experienciaDao.deleteById(id);
	}

}
