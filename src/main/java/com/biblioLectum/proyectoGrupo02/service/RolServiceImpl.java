package com.biblioLectum.proyectoGrupo02.service;

import com.biblioLectum.proyectoGrupo02.model.Rol;
import com.biblioLectum.proyectoGrupo02.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private RolRepository rolRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Rol> listarTodos() {
        return rolRepo.findAll();
    }
}