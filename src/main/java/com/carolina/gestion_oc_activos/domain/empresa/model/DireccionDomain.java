package com.carolina.gestion_oc_activos.domain.empresa.model;

import lombok.Data;

@Data
public class DireccionDomain {

    private Integer direccionId;
    private String calle;
    private String numero;
    private String ciudad;
    private String comuna;
    private String region;
}
