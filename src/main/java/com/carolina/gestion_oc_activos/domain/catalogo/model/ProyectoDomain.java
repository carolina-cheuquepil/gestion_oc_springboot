package com.carolina.gestion_oc_activos.domain.catalogo.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProyectoDomain {

    private Integer proyectoId;
    private String proyectoNombre;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private Boolean activo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
