package com.carolina.gestion_oc_activos.domain.proveedor.model;

import lombok.Data;

@Data
public class ProveedorDomain {
    private Integer proveedorId;
    private String razonSocial;
    private String nombre;
    private Integer rutNumero;
    private String rutDv;
    private Boolean activa;
}

// 07/04 Parte 02