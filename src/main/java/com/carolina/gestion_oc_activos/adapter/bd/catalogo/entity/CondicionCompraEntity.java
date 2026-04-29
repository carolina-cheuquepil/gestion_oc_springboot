package com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "condicion_compra")
@Data
public class CondicionCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condicion_compra_id")
    private Integer condicionCompraId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
}
