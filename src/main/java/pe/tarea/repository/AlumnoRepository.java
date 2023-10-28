package pe.tarea.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.tarea.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer>
{
	@Query(value = "select cur.curso_id, cur.nombre \r\n"
			+ "from alumnos_cursos pp \r\n"
			+ "inner join alumnos alum on pp.alumno_id=alum.alumno_id \r\n"
			+ "inner join cursos cur on pp.curso_id=cur.curso_id \r\n"
			+ "where alum.alumno_id=:param", nativeQuery = true)
	public abstract Collection<Object[]> alumno_curso(@Param("param") Integer alumnoId);
	
}
