package springbootbackendapirestcurriculum.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootbackendapirestcurriculum.models.dao.IPersonalDao;
import springbootbackendapirestcurriculum.models.entity.Personal;

@Service
public class PersonalServiceImpl implements IPersonalService{

	@Autowired
	private IPersonalDao personalDao;
	
	@Override
	public List<Personal> findAll() {
		return (List<Personal>) personalDao.findAll();
	}

	@Override
	public Personal findById(Long id) {
		return personalDao.findById(id).orElse(null);
	}

	@Override
	public Personal save(Personal personal) {
		return personalDao.save(personal);
	}

	@Override
	public void delete(Long id) {
		personalDao.deleteById(id);
	}

}
