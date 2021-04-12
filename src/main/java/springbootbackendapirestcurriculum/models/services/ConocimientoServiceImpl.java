package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springbootbackendapirestcurriculum.models.dao.IConocimientoDao;
import springbootbackendapirestcurriculum.models.entity.Conocimiento;
import springbootbackendapirestcurriculum.models.entity.Tecnologia;

@Service
public class ConocimientoServiceImpl implements IConocimientoService{
	
	@Autowired
	private IConocimientoDao conocimientoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Conocimiento> findAll() {
		return (List<Conocimiento>) conocimientoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Conocimiento findById(Long id) {
		return conocimientoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Conocimiento save(Conocimiento conocimiento) {
		return conocimientoDao.save(conocimiento);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		conocimientoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tecnologia> findAllTecnologias() {
		return conocimientoDao.findAllTecnologias();
	}

}
