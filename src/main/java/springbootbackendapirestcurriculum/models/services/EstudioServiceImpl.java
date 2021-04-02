package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootbackendapirestcurriculum.models.dao.IEstudioDao;
import springbootbackendapirestcurriculum.models.entity.Estudio;

@Service
public class EstudioServiceImpl implements IEstudioService{

	@Autowired
	private IEstudioDao estudioDao;
	
	@Override
	public List<Estudio> findAll() {
		return (List<Estudio>) estudioDao.findAll();
	}

	@Override
	public Estudio findById(Long id) {
		return estudioDao.findById(id).orElse(null);
	}

	@Override
	public Estudio save(Estudio estudio) {
		return estudioDao.save(estudio);
	}

	@Override
	public void delete(Long id) {
		estudioDao.deleteById(id);
	}

}
