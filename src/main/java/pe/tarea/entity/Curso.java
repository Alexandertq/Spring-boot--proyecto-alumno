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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable
{

	private static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cursoId;
	
	@Column
	private String nombre;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate finicio;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate ffin;
	
	
	@ManyToMany(mappedBy = "itemsCurso")
	private Set<Alumno> itemsAlumno=new HashSet<>();
	

	public Curso() {

	}

	public Curso(Integer cursoId, String nombre, LocalDate finicio, LocalDate ffin) {
		this.cursoId = cursoId;
		this.nombre = nombre;
		this.finicio = finicio;
		this.ffin = ffin;
	}


	public Integer getCursoId() {
		return cursoId;
	}


	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public LocalDate getFinicio() {
		return finicio;
	}




	public void setFinicio(LocalDate finicio) {
		this.finicio = finicio;
	}




	public LocalDate getFfin() {
		return ffin;
	}




	public void setFfin(LocalDate ffin) {
		this.ffin = ffin;
	}




	public Set<Alumno> getItemsAlumno() {
		return itemsAlumno;
	}


	public void setItemsAlumno(Set<Alumno> itemsAlumno) {
		this.itemsAlumno = itemsAlumno;
	}


	
	
	

	
}
