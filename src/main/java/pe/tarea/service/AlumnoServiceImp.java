package pe.tarea.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.tarea.entity.Alumno;
import pe.tarea.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService{
	
	@Autowired
	private AlumnoRepository repository;
	
	@Override
	@Transactional
	public void insert(Alumno alumno) {
		repository.save(alumno);
	}

	@Override
	@Transactional
	public void update(Alumno alumno) {
		repository.save(alumno);
	}

	@Override
	@Transactional
	public void delete(Integer alumnoId) {
		repository.deleteById(alumnoId);
	}

	@Override
	@Transactional(readOnly=true)
	public Alumno findById(Integer alumnoId) {
		return repository.findById(alumnoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Alumno> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Object[]> alumnos_cursos(Integer alumnoId) {
		// TODO Auto-generated method stub
		return repository.alumno_curso(alumnoId);
	}
}
