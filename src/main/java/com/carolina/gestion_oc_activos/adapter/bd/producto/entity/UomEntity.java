package com.carolina.gestion_oc_activos.adapter.bd.producto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "uom")
@Data
public class UomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uom_id")
    private Integer uomId;

    @Column(name = "codigo", nullable = false, length = 10, unique = true)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "activo")
    private Boolean activo;
}
