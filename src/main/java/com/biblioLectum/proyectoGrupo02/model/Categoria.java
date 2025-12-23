package com.biblioLectum.proyectoGrupo02.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "IdCategoria")
    private Long id;

    @Column(name = "NombreCategoria", nullable = false)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Estado")
    private boolean estado;


}
