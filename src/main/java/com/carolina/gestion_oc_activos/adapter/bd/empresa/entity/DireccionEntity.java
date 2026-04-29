package com.carolina.gestion_oc_activos.adapter.bd.empresa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "direccion")
@Data
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direccion_id")
    private Integer direccionId;

    @Column(name = "calle", nullable = false)
    private String calle;

    @Column(name = "numero", length = 20)
    private String numero;

    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;

    @Column(name = "comuna", length = 100)
    private String comuna;

    @Column(name = "region", length = 100)
    private String region;
}
