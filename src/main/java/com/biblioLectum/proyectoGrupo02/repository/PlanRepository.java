package com.biblioLectum.proyectoGrupo02.repository;

import com.biblioLectum.proyectoGrupo02.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByNombreContainingIgnoreCase(String keyword);
}
