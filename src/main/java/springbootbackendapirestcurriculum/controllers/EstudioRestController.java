package springbootbackendapirestcurriculum.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootbackendapirestcurriculum.models.entity.Estudio;
import springbootbackendapirestcurriculum.models.entity.Persona;
import springbootbackendapirestcurriculum.models.services.IEstudioService;
import springbootbackendapirestcurriculum.models.services.IPersonaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EstudioRestController {

	@Autowired
	private IEstudioService estudioService;
	
	@Autowired
	private IPersonaService personaService;
	
	@Secured("ROLE_USER")
	@GetMapping("/estudios")
	public List<Estudio> index(){
		return estudioService.findAll();
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/estudios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Estudio estudio = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			estudio = estudioService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if( estudio == null ) {
			response.put("mensaje", "El estudio ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Estudio>(estudio, HttpStatus.OK);  
	}
	
	@Secured("ROLE_USER")
	@PostMapping("/estudios/{id}")
	public ResponseEntity<?> create(@Valid @RequestBody Estudio estudio, BindingResult result, @PathVariable Long id) {
		
		Estudio estudioNew = null;
		Persona personaNew = null;
		Persona persona = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			/*
			List<String> errors = new ArrayList<>();
			
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo '" + err.getField() + "' " + err.getDefaultMessage());
			}
			*/
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map( err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
				
			response.put("errors", errors);
			
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			persona = personaService.findById(id);
			
			if(persona == null) {
				response.put("mensaje", "Error: no se pudo agregar el estudio, la persona ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
				return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
			}
			
			persona.addEstudio(estudio);
			
			personaNew = personaService.save(persona);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El estudio ha sido creado con exito");
		response.put("estudio", estudio);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);  
	}
	
	@Secured("ROLE_USER")
	@PutMapping("/estudios/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Estudio estudio, BindingResult result, @PathVariable Long id) {
		
		Estudio estudioActual = estudioService.findById(id);
		
		Estudio estudioUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			/*
			List<String> errors = new ArrayList<>();
			
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo '" + err.getField() + "' " + err.getDefaultMessage());
			}
			*/
			
			List<String> errors = result.getFieldErrors()
					.stream()
					.map( err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
				
			response.put("errors", errors);
			
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.BAD_REQUEST);
		}
		
		if( estudioActual == null ) {
			response.put("mensaje", "Error: no se pudo editar, el estudio ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			estudioActual.setFechaInicio(estudio.getFechaInicio());
			estudioActual.setFechaTermino(estudio.getFechaTermino());
			estudioActual.setLugar(estudio.getLugar());
			estudioActual.setTipo(estudio.getTipo());
			estudioActual.setTitulo(estudio.getTitulo());
			
			estudioUpdated = estudioService.save(estudioActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El estudio ha sido actualizado con exito");
		response.put("estudio", estudioUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_USER")
	@DeleteMapping("/estudios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		
			estudioService.delete(id);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el estudio de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El estudio eliminado con exito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
