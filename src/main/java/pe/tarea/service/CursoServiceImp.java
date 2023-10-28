package pe.tarea.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.tarea.entity.Curso;

import pe.tarea.repository.CursoRepository;

@Service
public class CursoServiceImp implements CursoService{

	@Autowired
	private CursoRepository repository;
	
	@Override
	@Transactional
	public void insert(Curso curso) {
		// TODO Auto-generated method stub
		repository.save(curso);
	}

	@Override
	@Transactional
	public void update(Curso curso) {
		// TODO Auto-generated method stub
		repository.save(curso);
	}

	@Override
	@Transactional
	public void delete(Integer cursoId) {
		// TODO Auto-generated method stub
		repository.deleteById(cursoId);
	}

	@Override
	@Transactional(readOnly=true)
	public Curso findById(Integer cursoId) {
		// TODO Auto-generated method stub
		return repository.findById(cursoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Curso> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
