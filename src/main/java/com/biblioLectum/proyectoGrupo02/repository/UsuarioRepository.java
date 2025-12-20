package com.biblioLectum.proyectoGrupo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.biblioLectum.proyectoGrupo02.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Para validar login
    Usuario findByCorreo(String correo);

    // Para validar que no se registren dos veces con el mismo DNI
    Usuario findByNumeroDocumento(String numeroDocumento);

}