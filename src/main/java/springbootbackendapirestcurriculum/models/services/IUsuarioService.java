package springbootbackendapirestcurriculum.models.services;

import springbootbackendapirestcurriculum.models.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
	
}
