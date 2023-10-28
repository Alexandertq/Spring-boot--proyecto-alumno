package pe.tarea.service;

import java.util.Collection;

import pe.tarea.entity.Curso;

public interface CursoService {

	public abstract void insert(Curso curso);
	public abstract void update(Curso curso);
	public abstract void delete(Integer cursoId);
	public abstract Curso findById(Integer cursoId);
	public abstract Collection<Curso> findAll();
}
