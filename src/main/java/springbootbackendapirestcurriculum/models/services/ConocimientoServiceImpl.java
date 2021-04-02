package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootbackendapirestcurriculum.models.dao.IConocimientoDao;
import springbootbackendapirestcurriculum.models.entity.Conocimiento;

@Service
public class ConocimientoServiceImpl implements IConocimientoService{
	
	@Autowired
	private IConocimientoDao conocimientoDao;

	@Override
	public List<Conocimiento> findAll() {
		return (List<Conocimiento>) conocimientoDao.findAll();
	}

	@Override
	public Conocimiento findById(Long id) {
		return conocimientoDao.findById(id).orElse(null);
	}

	@Override
	public Conocimiento save(Conocimiento conocimiento) {
		return conocimientoDao.save(conocimiento);
	}

	@Override
	public void delete(Long id) {
		conocimientoDao.deleteById(id);
	}

}
