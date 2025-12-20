package com.biblioLectum.proyectoGrupo02.model;

import com.biblioLectum.proyectoGrupo02.model.Categoria;


import jakarta.persistence.*;

@Entity
@Table (name= "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria idCategoria;



}
