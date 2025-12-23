package com.biblioLectum.proyectoGrupo02.service;

import com.biblioLectum.proyectoGrupo02.model.Categoria;
import com.biblioLectum.proyectoGrupo02.repository.CategoriaRepository;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listarTodos(){
        return repo.findAll();
    }

    @Override
    @Transactional
    public Categoria guardar(Categoria categoria){
        return repo.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar (Long id){
        repo.deleteById(id);
    }

}
