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

import springbootbackendapirestcurriculum.models.entity.Personal;
import springbootbackendapirestcurriculum.models.services.IPersonalService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PersonalRestControlles {

	@Autowired
	private IPersonalService personalService;
	
	@GetMapping("/personales")
	public List<Personal> index(){
		return personalService.findAll();
	}
	
	@GetMapping("/personales/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Personal personal = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			personal = personalService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if( personal == null ) {
			response.put("mensaje", "El personal ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Personal>(personal, HttpStatus.OK);  
	}
	
	@PostMapping("/personales")
	public ResponseEntity<?> create(@Valid @RequestBody Personal personal, BindingResult result) {
		
		Personal personalNew = null;
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
			personalNew = personalService.save(personal);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El personal ha sido creado con exito");
		response.put("personal", personalNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);  
	}
	
	@PutMapping("/personales/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Personal personal, BindingResult result, @PathVariable Long id) {
		
		Personal personalActual = personalService.findById(id);
		
		Personal personalUpdated = null;
		
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
		
		if( personalActual == null ) {
			response.put("mensaje", "Error: no se pudo editar, el personal ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			personalActual.setPrimerNombre(personal.getPrimerNombre());
			personalActual.setSegundoNombre(personal.getSegundoNombre());
			personalActual.setPrimerApellido(personal.getPrimerApellido());
			personalActual.setSegundoApellido(personal.getSegundoApellido());
			personalActual.setCalle(personal.getCalle());
			personalActual.setCiudad(personal.getCiudad());
			personalActual.setEmail(personal.getEmail());
			personalActual.setEstadoCivil(personal.getEstadoCivil());
			personalActual.setFechaNacimiento(personal.getFechaNacimiento());
			personalActual.setImagen(personal.getImagen());
			personalActual.setNacionalidad(personal.getNacionalidad());
			personalActual.setNumero(personal.getNumero());
			personalActual.setPresentacion(personal.getPresentacion());
			personalActual.setRun(personal.getRun());
			personalActual.setTelefono(personal.getTelefono());
			
			personalUpdated = personalService.save(personalActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El personal ha sido actualizado con exito");
		response.put("personal", personalUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/personales/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		
			personalService.delete(id);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el personal de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El personal eliminado con exito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
