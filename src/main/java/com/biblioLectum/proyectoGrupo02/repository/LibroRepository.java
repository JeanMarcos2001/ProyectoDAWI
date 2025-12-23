package com.biblioLectum.proyectoGrupo02.repository;

import com.biblioLectum.proyectoGrupo02.model.Libro;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
