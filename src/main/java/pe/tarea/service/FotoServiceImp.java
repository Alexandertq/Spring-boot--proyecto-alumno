package pe.tarea.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.tarea.entity.Foto;
import pe.tarea.repository.FotoRepository;

@Service
public class FotoServiceImp implements FotoService {

	@Autowired
	private FotoRepository repository;
	
	@Override
	@Transactional
	public void insert(Foto foto) {
		// TODO Auto-generated method stub
		repository.save(foto);
	}

	@Override
	@Transactional
	public void update(Foto foto) {
		// TODO Auto-generated method stub
		repository.save(foto);
	}

	@Override
	@Transactional
	public void delete(Integer fotoId) {
		// TODO Auto-generated method stub
		repository.deleteById(fotoId);
	}

	@Override
	@Transactional(readOnly = true)
	public Foto findById(Integer fotoId) {
		// TODO Auto-generated method stub
		return repository.findById(fotoId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Foto> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
