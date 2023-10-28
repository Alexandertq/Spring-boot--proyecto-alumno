package pe.tarea.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.tarea.entity.Universidad;

import pe.tarea.repository.UniversidadRepository;

@Service
public class UniversidadServiceImp implements UniversidadService{

	@Autowired
	private UniversidadRepository repository;
	
	@Override
	@Transactional
	public void insert(Universidad universidad) {
		// TODO Auto-generated method stub
		repository.save(universidad);
	}

	@Override
	@Transactional
	public void update(Universidad universidad) {
		// TODO Auto-generated method stub
		repository.save(universidad);
	}

	@Override
	@Transactional
	public void delete(Integer universidadId) {
		// TODO Auto-generated method stub
		repository.deleteById(universidadId);
	}

	@Override
	@Transactional(readOnly=true)
	public Universidad findById(Integer universidadId) {
		// TODO Auto-generated method stub
		return repository.findById(universidadId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Universidad> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
