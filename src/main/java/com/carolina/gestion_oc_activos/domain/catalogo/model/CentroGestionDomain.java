package com.carolina.gestion_oc_activos.domain.catalogo.model;

import lombok.Data;

@Data
public class CentroGestionDomain {

    private Integer centroGestionId;
    private String codigo;
    private String nombre;
    private Boolean activo;
}
