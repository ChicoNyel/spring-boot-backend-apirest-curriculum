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

import springbootbackendapirestcurriculum.models.entity.Experiencia;
import springbootbackendapirestcurriculum.models.entity.Persona;
import springbootbackendapirestcurriculum.models.services.IExperienciaService;
import springbootbackendapirestcurriculum.models.services.IPersonaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ExperienciaRestController {

	@Autowired
	private IExperienciaService experienciaService;
	
	@Autowired
	private IPersonaService personaService;
	
	@Secured("ROLE_USER")
	@GetMapping("/experiencias")
	public List<Experiencia> index(){
		return experienciaService.findAll();
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/experiencias/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Experiencia experiencia = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			experiencia = experienciaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if( experiencia == null ) {
			response.put("mensaje", "El experiencia ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Experiencia>(experiencia, HttpStatus.OK);  
	}
	
	@Secured("ROLE_USER")
	@PostMapping("/experiencias/{username}")
	public ResponseEntity<?> create(@Valid @RequestBody Experiencia experiencia, BindingResult result, @PathVariable String username) {
		
		Experiencia experienciaNew = null;
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

			persona = personaService.findByUsername(username);
			
			if(persona == null) {
				response.put("mensaje", "Error: no se pudo agregar la experiencia, la persona username: ".concat(username).concat(" no existe en la base de datos!"));
				return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
			}
			
			persona.addExperiencia(experiencia);
			
			personaNew = personaService.save(persona);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El experiencia ha sido creado con exito");
		response.put("experiencia", experiencia);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);  
	}
	
	@Secured("ROLE_USER")
	@PutMapping("/experiencias/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Experiencia experiencia, BindingResult result, @PathVariable Long id) {
		
		Experiencia experienciaActual = experienciaService.findById(id);
		
		Experiencia experienciaUpdated = null;
		
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
		
		if( experienciaActual == null ) {
			response.put("mensaje", "Error: no se pudo editar, el experiencia ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		try {
		
			experienciaActual.setFechaInicio(experiencia.getFechaInicio());
			experienciaActual.setFechaTermino(experiencia.getFechaTermino());
			experienciaActual.setDescripcion(experiencia.getDescripcion());
			experienciaActual.setLugar(experiencia.getLugar());
			
			experienciaUpdated = experienciaService.save(experienciaActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El experiencia ha sido actualizado con exito");
		response.put("experiencia", experienciaUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_USER")
	@DeleteMapping("/experiencias/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		
			experienciaService.delete(id);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el experiencia de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El experiencia eliminado con exito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
