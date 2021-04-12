package springbootbackendapirestcurriculum.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tecnologias")
public class Tecnologia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4258062576483993760L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "nombre")
	private String nombre;

	@NotBlank
	@Column(name = "lenguaje")
	private String lenguaje;
	
	@NotBlank
	@Column(name = "tipo")
	private String tipo;

	public Tecnologia() {
	}

	public Tecnologia(Long id, @NotBlank String nombre, @NotBlank String lenguaje, @NotBlank String tipo) {
		this.id = id;
		this.nombre = nombre;
		this.lenguaje = lenguaje;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Tecnologia [id=" + id + ", nombre=" + nombre + ", lenguaje=" + lenguaje + ", tipo=" + tipo + "]";
	}

}
