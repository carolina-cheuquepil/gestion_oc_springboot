package com.carolina.gestion_oc_activos.domain.producto.model;

import lombok.Data;

@Data
public class TipoProductoDomain {

    private Integer tipoProductoId;
    private String codigo;
    private String nombre;
    private Boolean activo;
}
