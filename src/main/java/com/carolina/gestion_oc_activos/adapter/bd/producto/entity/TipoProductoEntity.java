package com.carolina.gestion_oc_activos.adapter.bd.producto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipo_producto")
@Data
public class TipoProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_producto_id")
    private Integer tipoProductoId;

    @Column(name = "codigo", nullable = false, length = 20, unique = true)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "activo", nullable = false)
    private Boolean activo;
}
