package pe.tarea.entity;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable
{
	
	private static final long serialVersionUID=1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer alumnoId;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fnacimiento;
	
	@Column
	private String email;
	
	@Column
	private Integer telefono;
	
	@ManyToOne
	@JoinColumn(name = "universidad_id",nullable=false )
	private Universidad universidad;
	
	@OneToOne
	@JoinColumn(name="foto_id",unique=true,nullable=false)
	private Foto foto;
	
	
	
	@ManyToMany
	@JoinTable(name = "alumnos_cursos",
		joinColumns = @JoinColumn(name = "alumno_id"),
		inverseJoinColumns = @JoinColumn(name="curso_id"))
	private Set<Curso> itemsCurso=new HashSet<>();
	
	
	public Alumno() {
		
	}

	public Alumno(Integer alumnoId, String nombres, String apellidos, LocalDate fnacimiento, String email,
			Integer telefono) {
		this.alumnoId = alumnoId;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fnacimiento = fnacimiento;
		this.email = email;
		this.telefono = telefono;

	}

	public void addCurso(Curso curso) {
		itemsCurso.add(curso);
	}

	public Integer getAlumnoId() {
		return alumnoId;
	}


	public void setAlumnoId(Integer alumnoId) {
		this.alumnoId = alumnoId;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public LocalDate getFnacimiento() {
		return fnacimiento;
	}


	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}



	public Universidad getUniversidad() {
		return universidad;
	}



	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}


	public Foto getFoto() {
		return foto;
	}


	public void setFoto(Foto foto) {
		this.foto = foto;
	}


	public Set<Curso> getItemsCurso() {
		return itemsCurso;
	}


	public void setItemsCurso(Set<Curso> itemsCurso) {
		this.itemsCurso = itemsCurso;
	}

	
	

	
	
	

}
