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
@Table(name = "estudios")
public class Estudio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8727942901359967564L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Ej: Ingeniero civil 
	@NotBlank
	@Column(name = "titulo")
	private String titulo;
	
	//Universidad, Udemy u otra institucio oficial
	@NotBlank
	@Column(name = "lugar")
	private String lugar;
	
	// Universitario o Certificacion
	@NotBlank
	@Column(name = "tipo")
	private String tipo;
	
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

	public Estudio() {
	}

	public Estudio(Long id, @NotBlank String titulo, @NotBlank String lugar, @NotBlank String tipo,
			@NotNull Date fechaInicio, @NotNull Date fechaTermino) {
		this.id = id;
		this.titulo = titulo;
		this.lugar = lugar;
		this.tipo = tipo;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		return "Estudio [id=" + id + ", titulo=" + titulo + ", lugar=" + lugar + ", tipo="
				+ tipo + ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + "]";
	}
	
}
