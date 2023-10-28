package pe.tarea.service;

import java.util.Collection;

import pe.tarea.entity.Alumno;

public interface AlumnoService {
	
	
	public abstract void insert(Alumno alumno);
	public abstract void update(Alumno alumno);
	public abstract void delete(Integer alumnoId);
	public abstract Alumno findById(Integer alumnoId);
	public abstract Collection<Alumno> findAll();

	public abstract Collection<Object[]> alumnos_cursos(Integer alumnoId);
}
