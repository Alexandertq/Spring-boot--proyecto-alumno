package pe.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.tarea.entity.Foto;

public interface FotoRepository extends JpaRepository<Foto, Integer> {

}