package com.biblioLectum.proyectoGrupo02.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "planes")
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

    public int getLimiteLibros() {
        return limiteLibros;
    }

    public void setLimiteLibros(int limiteLibros) {
        this.limiteLibros = limiteLibros;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public double getCostoDiaRetraso() {
        return costoDiaRetraso;
    }

    public void setCostoDiaRetraso(double costoDiaRetraso) {
        this.costoDiaRetraso = costoDiaRetraso;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public void setPrecioMensual(double precioMensual) {
        this.precioMensual = precioMensual;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEsPublico() {
        return esPublico;
    }

    public void setEsPublico(boolean esPublico) {
        this.esPublico = esPublico;
    }
}