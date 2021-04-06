package springbootbackendapirestcurriculum.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conocimientos")
public class Conocimiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4721130213388353430L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
	@Min(1)
	@Max(10)
	@Column(name = "autoevaluacion")
	private int autoevaluacion;

	public Conocimiento() {
	}

	public Conocimiento(Long id, @NotBlank String descripcion, @NotNull int autoevaluacion) {
		this.id = id;
		this.descripcion = descripcion;
		this.autoevaluacion = autoevaluacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAutoevaluacion() {
		return autoevaluacion;
	}

	public void setAutoevaluacion(int autoevaluacion) {
		this.autoevaluacion = autoevaluacion;
	}

	@Override
	public String toString() {
		return "Conocimiento [id=" + id + ", descripcion=" + descripcion + ", autoevaluacion="
				+ autoevaluacion + "]";
	}
	
}
