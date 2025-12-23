package com.biblioLectum.proyectoGrupo02.service;

import com.biblioLectum.proyectoGrupo02.model.Libro;
import com.biblioLectum.proyectoGrupo02.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.PublicKey;
import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService{

    @Autowired
    private LibroRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> listarTodos(){
        return repo.findAll();
    }

    @Override
    @Transactional
    public Libro guardar (Libro libro){
        return repo.save(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro buscarPorId(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id){
        repo.deleteById(id);
    }
}
