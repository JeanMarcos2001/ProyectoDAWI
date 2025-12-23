package com.biblioLectum.proyectoGrupo02.repository;

import com.biblioLectum.proyectoGrupo02.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByNombre(String nombre);
}
