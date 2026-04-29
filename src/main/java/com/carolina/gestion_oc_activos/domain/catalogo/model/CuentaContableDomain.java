package com.carolina.gestion_oc_activos.domain.catalogo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CuentaContableDomain {

    private Integer cuentaId;
    private String codigo;
    private String nombre;
    private String tipo;
    private Boolean activo;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
