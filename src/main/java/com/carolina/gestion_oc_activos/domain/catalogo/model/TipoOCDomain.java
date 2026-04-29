package com.carolina.gestion_oc_activos.domain.catalogo.model;

import lombok.Data;

@Data
public class TipoOCDomain {

    private Integer tipoOcId;
    private String nombre;
    private Boolean afectaIva;
    private Boolean requiereRetencion;
}
