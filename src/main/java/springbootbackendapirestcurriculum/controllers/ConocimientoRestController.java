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

import springbootbackendapirestcurriculum.models.entity.Conocimiento;
import springbootbackendapirestcurriculum.models.entity.Persona;
import springbootbackendapirestcurriculum.models.entity.Tecnologia;
import springbootbackendapirestcurriculum.models.services.IConocimientoService;
import springbootbackendapirestcurriculum.models.services.IPersonaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ConocimientoRestController {

	@Autowired
	private IConocimientoService conocimientoService;
	
	@Autowired
	private IPersonaService personaService;
	
	@Secured("ROLE_USER")
	@GetMapping("/conocimientos")
	public List<Conocimiento> index(){
		return conocimientoService.findAll();
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/conocimientos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Conocimiento conocimiento = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			conocimiento = conocimientoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if( conocimiento == null ) {
			response.put("mensaje", "El conocimiento ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Conocimiento>(conocimiento, HttpStatus.OK);  
	}
	
	@Secured("ROLE_USER")
	@PostMapping("/conocimientos/{username}")
	public ResponseEntity<?> create(@Valid @RequestBody Conocimiento conocimiento, BindingResult result, @PathVariable String username) {
		
		Conocimiento conocimientoNew = null;
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
				response.put("mensaje", "Error: no se pudo agregar el conocimiento, la persona username: ".concat(username).concat(" no existe en la base de datos!"));
				return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
			}
			
			persona.addConocimiento(conocimiento);
			
			personaNew = personaService.save(persona);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El conocimiento ha sido creado con exito");
		response.put("conocimiento", conocimiento);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);  
	}
	
	@Secured("ROLE_USER")
	@PutMapping("/conocimientos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Conocimiento conocimiento, BindingResult result, @PathVariable Long id) {
		
		Conocimiento conocimientoActual = conocimientoService.findById(id);
		
		Conocimiento conocimientoUpdated = null;
		
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
		
		if( conocimientoActual == null ) {
			response.put("mensaje", "Error: no se pudo editar, el conocimiento ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		try {
		
			conocimientoActual.setAutoevaluacion(conocimiento.getAutoevaluacion());
			conocimientoActual.setTecnologia(conocimiento.getTecnologia());
			
			conocimientoUpdated = conocimientoService.save(conocimientoActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El conocimiento ha sido actualizado con exito");
		response.put("conocimiento", conocimientoUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured("ROLE_USER")
	@DeleteMapping("/conocimientos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		
			conocimientoService.delete(id);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el conocimiento de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El conocimiento eliminado con exito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/conocimientos/tecnologias")
	public List<Tecnologia> listarTecnologias(){
		return conocimientoService.findAllTecnologias();
	}
	
}
