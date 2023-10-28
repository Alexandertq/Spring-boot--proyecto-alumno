package pe.tarea.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "universidades")
public class Universidad  implements Serializable
{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer universidadId;
	
	@Column
	private String nombre;
	
	@Column
	private Integer telefono;
	
	@Column
	private String ubicacion;
	
	@Column
	private String website;
	
	
	
	@OneToMany(mappedBy = "universidad")
	private Collection<Alumno> itemsAlumno=new ArrayList<>();
	
	public Universidad() {	}
	

	public Universidad(Integer universidadId, String nombre, Integer telefono, String ubicacion,String website) {
		this.universidadId = universidadId;
		this.nombre = nombre;
		this.telefono = telefono;
		this.ubicacion = ubicacion;
		this.website = website;
	}


	public Integer getUniversidadId() {
		return universidadId;
	}

	public void setUniversidadId(Integer universidadId) {
		this.universidadId = universidadId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public Collection<Alumno> getItemsAlumno() {
		return itemsAlumno;
	}


	public void setItemsAlumno(Collection<Alumno> itemsAlumno) {
		this.itemsAlumno = itemsAlumno;
	}



	
	
	

	
}
