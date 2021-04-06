package springbootbackendapirestcurriculum.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2437624779267892111L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private List<Conocimiento> conocimientos;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private List<Estudio> estudios;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private List<Experiencia> experiencias;

	@NotEmpty
	@Column(name = "username")
	private String username;

	@NotEmpty
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "enabled")
	private Boolean enabled;

	@NotNull
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaRegistro;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;

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
	@JsonFormat(pattern="yyyy-MM-dd", timezone="America/Santiago")
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
	
	@PrePersist
	public void prePersist() {
		this.fechaRegistro = new Date();
	}

	public Usuario() {
		this.conocimientos = new ArrayList<>();
		this.estudios = new ArrayList<>();
		this.experiencias = new ArrayList<>();
	}

	public Usuario(Long id, List<Conocimiento> conocimientos, List<Estudio> estudios,
			List<Experiencia> experiencias, @NotEmpty String username, @NotEmpty String password,
			@NotNull Boolean enabled, @NotNull Date fechaRegistro, List<Role> roles, @NotBlank String primerNombre,
			@NotBlank String segundoNombre, @NotBlank String primerApellido, @NotBlank String segundoApellido,
			@NotBlank String telefono, @NotBlank @Email String email, @NotBlank String run,
			@NotBlank String estadoCivil, String imagen, @NotBlank String nacionalidad,
			@NotNull Date fechaNacimiento, String presentacion, @NotBlank String ciudad, @NotBlank String calle,
			@NotNull int numero) {
		this.id = id;
		this.conocimientos = conocimientos;
		this.estudios = estudios;
		this.experiencias = experiencias;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.fechaRegistro = fechaRegistro;
		this.roles = roles;
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

	public List<Conocimiento> getConocimientos() {
		return conocimientos;
	}

	public void setConocimientos(List<Conocimiento> conocimientos) {
		this.conocimientos = conocimientos;
	}
	
	public void addConocimiento(Conocimiento conocimiento) {
		this.conocimientos.add(conocimiento);
	}

	public List<Estudio> getEstudios() {
		return estudios;
	}

	public void setEstudios(List<Estudio> estudios) {
		this.estudios = estudios;
	}
	
	public void addEstudio(Estudio estudio) {
		this.estudios.add(estudio);
	}

	public List<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}
	
	public void addExperiencia(Experiencia experiencia) {
		this.experiencias.add(experiencia);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
		return "Usuario [id=" + id + ", conocimientos=" + conocimientos + ", estudios="
				+ estudios + ", experiencias=" + experiencias + ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + ", fechaRegistro=" + fechaRegistro + ", roles=" + roles + ", primerNombre="
				+ primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", telefono=" + telefono + ", email=" + email + ", run="
				+ run + ", estadoCivil=" + estadoCivil + ", imagen=" + imagen + ", nacionalidad=" + nacionalidad
				+ ", fechaNacimiento=" + fechaNacimiento + ", presentacion=" + presentacion + ", ciudad=" + ciudad
				+ ", calle=" + calle + ", numero=" + numero + "]";
	}

}
