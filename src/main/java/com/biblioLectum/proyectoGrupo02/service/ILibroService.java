package com.biblioLectum.proyectoGrupo02.service;

import com.biblioLectum.proyectoGrupo02.model.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> listarTodos();
    Libro guardar(Libro libro);
    Libro buscarPorId(Long id);
    void eliminar (Long id);
}
