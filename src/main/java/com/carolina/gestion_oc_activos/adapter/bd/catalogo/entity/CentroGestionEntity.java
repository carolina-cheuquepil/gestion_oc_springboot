package com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "centro_gestion")
@Data
public class CentroGestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "centro_gestion_id")
    private Integer centroGestionId;

    @Column(name = "codigo", nullable = false, length = 10, unique = true)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;


}
