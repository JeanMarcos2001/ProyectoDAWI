package com.biblioLectum.proyectoGrupo02.model;

import com.biblioLectum.proyectoGrupo02.model.Categoria;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table (name= "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLibro")
    private Long id;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "Editorial")
    private String editorial;

    @ManyToOne
    @JoinColumn(name="IdCategoria", nullable = false)
    private Categoria categoria;

    @Column(name = "AnioPublicacion")
    private int anioPublicacion;

    @Column(name = "StockTotal")
    private int stockTotal;

    @Column(name = "StockDisponible")
    private int stockDispo;

    @Column(name = "PortadaUrl")
    private String portadaUrl;

    @Column(name = "EstadoLibro")
    private boolean estado;

    @CreationTimestamp
    @Column(name = "FechaRegistro", updatable = false)
    private LocalDateTime fechaRegistro;

}
