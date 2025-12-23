package com.biblioLectum.proyectoGrupo02.repository;

import com.biblioLectum.proyectoGrupo02.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByNombreContainingIgnoreCase(String keyword);
}
