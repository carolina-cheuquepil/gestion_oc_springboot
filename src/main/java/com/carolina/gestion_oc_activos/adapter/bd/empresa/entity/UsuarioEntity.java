package com.carolina.gestion_oc_activos.adapter.bd.empresa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "apellido", length = 100)
    private String apellido;

    @Column(name = "usuario", length = 50, unique = true)
    private String usuario;

    @Column(name = "correo", length = 150, unique = true)
    private String correo;

    @Column(name = "clave", length = 255)
    private String clave;

    @Column(name = "perfil_id")
    private Integer perfilId;

    @Column(name = "activo")
    private Boolean activo = true;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;
}
