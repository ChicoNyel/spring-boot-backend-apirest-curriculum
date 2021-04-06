package springbootbackendapirestcurriculum.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;
	
	@NotBlank
	@Column(name = "lugar")
	private String lugar;
	
	@NotNull
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="America/Santiago")
	private Date fechaInicio;
	
	@NotNull
	@Column(name = "fecha_termino")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd", timezone="America/Santiago")
	private Date fechaTermino;

	public Experiencia() {
	}

	public Experiencia(Long id, @NotBlank String descripcion, @NotBlank String lugar, @NotNull Date fechaInicio,
			@NotNull Date fechaTermino) {
		this.id = id;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
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

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
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
		return "Experiencia [id=" + id + ", descripcion=" + descripcion + ", lugar=" + lugar + ", fechaInicio="
				+ fechaInicio + ", fechaTermino=" + fechaTermino + "]";
	}
	
}
