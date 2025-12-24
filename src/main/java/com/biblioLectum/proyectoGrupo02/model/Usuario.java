package com.biblioLectum.proyectoGrupo02.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp; // Para la fecha automática
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private Long id;

    @Column(name = "NombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "NumeroDocumento", nullable = false, unique = true)
    private String numeroDocumento;

    @Column(name = "Estado", nullable = false)
    private Boolean estado = true;

    @CreationTimestamp // para que spring ponga la fecha al momento en q se registra
    @Column(name = "FechaCreacion", updatable = false)
    private LocalDateTime fechaCreacion;

    // relaciones de CLAVES FORÁNEAS

    // 1. con ROL
    @ManyToOne
    @JoinColumn(name = "IdRol", nullable = false) // Nombre de la columna en tabla Usuarios
    private Rol rol;

    // 2. con PLAN
    @ManyToOne
    @JoinColumn(name = "IdPlan", nullable = false) // Nombre de la columna en tabla Usuarios
    private Plan plan;


    // DATOS DE LOGIN
    @Column(name = "Correo", unique = true)
    private String correo;

    @Column(name = "Password")
    private String password;

    // DATOS DE PERFIL, estos son opcionales
    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "UrlComprobanteDomicilio")
    private String urlComprobante;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "FotoUrl")
    private String fotoUrl;

    @Column(name = "Genero")
    private String genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrlComprobante() {
        return urlComprobante;
    }

    public void setUrlComprobante(String urlComprobante) {
        this.urlComprobante = urlComprobante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}