package com.biblioLectum.proyectoGrupo02.service;

import com.biblioLectum.proyectoGrupo02.model.Usuario;
import com.biblioLectum.proyectoGrupo02.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //esto le dice a Spring que aquí hay lógica de negocio
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository repositorio;

    //LISTAMOS TODOS LOS USUARIOS
    @Override
    @Transactional(readOnly = true) // sirve para optimizar lectura de datos.
    public List<Usuario> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    @Transactional // Si algo falla aquí, se hace rollback automático
    public Usuario guardar(Usuario usuario) {
        // AQUÍ IRÍA LA LÓGICA DE NEGOCIO
        // Ejemplo futuro: if (usuario.getId() == null) { encriptarPassword(usuario); }
        return repositorio.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}