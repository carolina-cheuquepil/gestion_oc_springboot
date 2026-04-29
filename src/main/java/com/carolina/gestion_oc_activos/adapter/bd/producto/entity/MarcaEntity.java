package com.carolina.gestion_oc_activos.adapter.bd.producto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marca")
@Data
public class MarcaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marca_id")
    private Integer marcaId;

    @Column(name = "marca_nombre", nullable = false, length = 100)
    private String marcaNombre;
}
