package springbootbackendapirestcurriculum.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "conocimientos")
public class Conocimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4721130213388353430L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "la tecnologia no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tecnologia_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Tecnologia tecnologia;

	@NotNull
	@Min(1)
	@Max(10)
	@Column(name = "autoevaluacion")
	private int autoevaluacion;

	public Conocimiento() {
	}

	public Conocimiento(Long id, Tecnologia tecnologia, @NotNull @Min(1) @Max(10) int autoevaluacion) {
		this.id = id;
		this.tecnologia = tecnologia;
		this.autoevaluacion = autoevaluacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public int getAutoevaluacion() {
		return autoevaluacion;
	}

	public void setAutoevaluacion(int autoevaluacion) {
		this.autoevaluacion = autoevaluacion;
	}

	@Override
	public String toString() {
		return "Conocimiento [id=" + id + ", tecnologia=" + tecnologia + ", autoevaluacion=" + autoevaluacion + "]";
	}

}
