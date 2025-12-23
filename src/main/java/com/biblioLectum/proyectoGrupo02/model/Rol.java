package com.biblioLectum.proyectoGrupo02.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol")
    private Long id;

    @Column(name = "NombreRol", nullable = false, unique = true)
    private String nombre;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
}