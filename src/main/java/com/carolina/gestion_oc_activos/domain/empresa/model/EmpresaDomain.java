package com.carolina.gestion_oc_activos.domain.empresa.model;

import lombok.Data;

@Data
public class EmpresaDomain {

    private Integer empresaId;
    private Integer codigoEmpresa;
    private String razonSocial;
    private String nombre;
    private Integer rutNumero;
    private String rutDv;
    private Boolean activa;
}
