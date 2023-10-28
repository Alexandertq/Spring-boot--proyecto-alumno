package pe.tarea.service;

import java.util.Collection;

import pe.tarea.entity.Universidad;

public interface UniversidadService {

	public abstract void insert(Universidad universidad);
	public abstract void update(Universidad universidad);
	public abstract void delete(Integer universidadId);
	public abstract Universidad findById(Integer universidadId);
	public abstract Collection<Universidad> findAll();
}
