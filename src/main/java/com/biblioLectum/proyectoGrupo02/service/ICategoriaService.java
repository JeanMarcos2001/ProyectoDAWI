package com.biblioLectum.proyectoGrupo02.service;
import com.biblioLectum.proyectoGrupo02.model.Categoria;
import java.util.List;

public interface ICategoriaService {
    List<Categoria> listarTodos();
    Categoria guardar (Categoria categoria);
    Categoria buscarPorId(Long id);
    void eliminar (Long id);
}
