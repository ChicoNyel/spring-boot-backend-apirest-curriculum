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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "personales")
public class Personal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5386666446680782096L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "primer_nombre")
	private String primerNombre;

	@NotBlank
	@Column(name = "segundo_nombre")
	private String segundoNombre;

	@NotBlank
	@Column(name = "primer_apellido")
	private String primerApellido;

	@NotBlank
	@Column(name = "segundo_apellido")
	private String segundoApellido;

	@NotBlank
	@Column(name = "telefono")
	private String telefono;

	@NotBlank
	@Email
	@Column(name = "email")
	private String email;

	@NotBlank
	@Column(name = "run")
	private String run;

	@NotBlank
	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column(name = "imagen")
	private String imagen;

	@NotBlank
	@Column(name = "nacionalidad")
	private String nacionalidad;

	@NotNull
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date fechaNacimiento;

	@Column(name = "presentacion")
	private String presentacion;

	@NotBlank
	@Column(name = "ciudad")
	private String ciudad;

	@NotBlank
	@Column(name = "calle")
	private String calle;

	@NotNull
	@Column(name = "numero")
	private int numero;

	public Personal() {
	}

	public Personal(Long id, @NotBlank String primerNombre, @NotBlank String segundoNombre,
			@NotBlank String primerApellido, @NotBlank String segundoApellido, @NotBlank String telefono,
			@NotBlank @Email String email, @NotBlank String run, @NotBlank String estadoCivil, String imagen,
			@NotBlank String nacionalidad, @NotNull @Past Date fechaNacimiento, String presentacion,
			@NotBlank String ciudad, @NotBlank String calle, @NotNull int numero) {
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.email = email;
		this.run = run;
		this.estadoCivil = estadoCivil;
		this.imagen = imagen;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.presentacion = presentacion;
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", telefono="
				+ telefono + ", email=" + email + ", run=" + run + ", estadoCivil=" + estadoCivil + ", imagen=" + imagen
				+ ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", presentacion="
				+ presentacion + ", ciudad=" + ciudad + ", calle=" + calle + ", numero=" + numero + "]";
	}

}
