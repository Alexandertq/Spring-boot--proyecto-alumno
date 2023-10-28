package pe.tarea.service;

import java.util.Collection;


import pe.tarea.entity.Foto;

public interface FotoService {

	
	public abstract void insert(Foto foto);
	public abstract void update(Foto foto);
	public abstract void delete(Integer fotoId);
	public abstract Foto findById(Integer fotoId);
	public abstract Collection<Foto> findAll();
}
