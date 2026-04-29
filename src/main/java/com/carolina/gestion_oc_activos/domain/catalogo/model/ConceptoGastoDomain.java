package com.carolina.gestion_oc_activos.domain.catalogo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConceptoGastoDomain {

    private Integer conceptoGastoId;
    private String codigo;
    private String nombre;
    private Boolean activo;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
