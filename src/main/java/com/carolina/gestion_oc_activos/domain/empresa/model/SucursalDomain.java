package com.carolina.gestion_oc_activos.domain.empresa.model;

import lombok.Data;

@Data
public class SucursalDomain {

    private Integer sucursalId;
    private EmpresaDomain empresa;
    private String codigoSucursal;
    private String nombre;
    private Boolean activa;
    private DireccionDomain direccion;
}
