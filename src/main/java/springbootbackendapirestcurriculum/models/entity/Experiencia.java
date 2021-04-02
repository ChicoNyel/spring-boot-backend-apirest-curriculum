package springbootbackendapirestcurriculum.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "experiencias")
public class Experiencia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 122685068551397034L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	
	@NotNull
	@Column(name = "fecha_termino")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaTermino;

	public Experiencia() {
	}

	public Experiencia(Long id, Usuario usuario, @NotBlank String descripcion, @NotNull Date fechaInicio,
			@NotNull Date fechaTermino) {
		this.id = id;
		this.usuario = usuario;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	@Override
	public String toString() {
		return "Experiencia [id=" + id + ", usuario=" + usuario + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", fechaTermino=" + fechaTermino + "]";
	}
	
}