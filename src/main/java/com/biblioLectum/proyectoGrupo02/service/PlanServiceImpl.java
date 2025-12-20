package com.biblioLectum.proyectoGrupo02.service;

import com.biblioLectum.proyectoGrupo02.model.Plan;
import com.biblioLectum.proyectoGrupo02.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PlanServiceImpl implements IPlanService {

    @Autowired
    private PlanRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<Plan> listarTodos() {
        return repo.findAll();
    }
}