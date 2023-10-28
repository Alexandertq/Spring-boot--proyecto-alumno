package pe.tarea.entity;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tika.Tika;


@Entity
@Table(name = "fotos")
public class Foto implements Serializable
{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fotoId;
	
	@Column
	private String nombre;
	
	@Column(columnDefinition="longblob")
    private byte[] archivo;
	
	@OneToOne(mappedBy="foto")
    private Alumno alumno;

	
	public Foto() {
		// TODO Auto-generated constructor stub
	}

	public Foto(Integer fotoId, String nombre, byte[] archivo) {
		this.fotoId = fotoId;
		this.nombre = nombre;
		this.archivo = archivo;
	}

	public Integer getFotoId() {
		return fotoId;
	}

	public void setFotoId(Integer fotoId) {
		this.fotoId = fotoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
    //obtener archivo en Base64
    public String getBase64Fot() {
        return Base64.getEncoder().encodeToString(this.archivo);
    }

    //obtener el tipo de archivo (jpeg,png,gif,...)
    public String getTypeFot() {
        return new Tika().detect(this.archivo);
    }
	
	
}