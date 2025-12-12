package com.biblioLectum.proyectoGrupo02.controller;

import com.biblioLectum.proyectoGrupo02.model.Plan;
import com.biblioLectum.proyectoGrupo02.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/planes")
public class PlanController {

    private final PlanRepository repository;

    public PlanController(PlanRepository repository)
    {
        this.repository = repository;
    }




}
