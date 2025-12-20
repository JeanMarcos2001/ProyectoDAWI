package com.biblioLectum.proyectoGrupo02.service;

import com.biblioLectum.proyectoGrupo02.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarTodos();
    Usuario guardar(Usuario usuario);
    Usuario buscarPorId(Long id);
    void eliminar(Long id);

    // aqui agregaremos los métodos especiales
    // como: validarLogin(String email, String pass)
}