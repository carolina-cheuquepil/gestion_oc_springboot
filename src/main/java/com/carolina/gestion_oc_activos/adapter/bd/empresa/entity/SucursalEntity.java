package com.carolina.gestion_oc_activos.adapter.bd.empresa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sucursal")
@Data
public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sucursal_id")
    private Integer sucursalId;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaEntity empresa;

    @Column(name = "codigo_sucursal", nullable = false, length = 20, unique = true)
    private String codigoSucursal;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "activa")
    private Boolean activa = true;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private DireccionEntity direccion;
}
