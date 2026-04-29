package com.carolina.gestion_oc_activos.domain.catalogo.model;

import lombok.Data;

@Data
public class ContactoDomain {

    private Integer contactoId;
    private String nombres;
    private String apellidos;
    private String email;
    private String celular;
}
