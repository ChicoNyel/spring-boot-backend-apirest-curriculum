package springbootbackendapirestcurriculum.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name = "autoevaluacion")
	private int autoevaluacion;

	public Conocimiento() {
	}

	public Conocimiento(Long id, Usuario usuario, @NotBlank String descripcion, @NotNull int autoevaluacion) {
		this.id = id;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.autoevaluacion = autoevaluacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return "Conocimiento [id=" + id + ", usuario=" + usuario + ", descripcion=" + descripcion + ", autoevaluacion="
				+ autoevaluacion + "]";
	}
	
}
