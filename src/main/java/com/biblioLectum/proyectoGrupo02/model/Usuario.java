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

    @Column(name = "contraseña")
    private String password;

    // DATOS DE PERFIL, estos son opcionales
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "urlComprobanteDomicilio")
    private String urlComprobante;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fotoUrl")
    private String fotoUrl;

    @Column(name = "genero") // Cuidado con la tilde en la BD
    private String genero;
}