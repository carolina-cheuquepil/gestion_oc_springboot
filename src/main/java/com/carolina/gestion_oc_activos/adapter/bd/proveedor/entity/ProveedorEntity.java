package com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "proveedor")
@Data
public class ProveedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_id")
    private Integer proveedorId;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "rut_numero")
    private Integer rutNumero;

    @Column(name = "rut_dv")
    private String rutDv;

    @Column(name = "empresa_estado")
    private Boolean activa;
}
// 07/04 Parte 01