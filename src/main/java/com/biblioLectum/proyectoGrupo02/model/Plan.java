package com.biblioLectum.proyectoGrupo02.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // crear getters y setters automáticamente
@Entity
@Table(name = "Planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPlan")
    private Long id;

    @Column(name = "NombrePlan")
    private String nombre;

    @Column(name = "LimiteLibros")
    private int limiteLibros;

    @Column(name = "DiasPrestamo")
    private int diasPrestamo;

    @Column(name = "CostoDiaRetraso")
    private double costoDiaRetraso;

    @Column(name = "PrecioMensual")
    private double precioMensual;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "EsPublico")
    private boolean esPublico;
}