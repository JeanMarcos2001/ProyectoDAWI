package com.biblioLectum.proyectoGrupo02.repository;

import com.biblioLectum.proyectoGrupo02.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
