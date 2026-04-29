package com.carolina.gestion_oc_activos.domain.empresa.model;

import lombok.Data;

@Data
public class UsuarioDomain {

    private Integer usuarioId;
    private String nombre;
    private String apellido;
    private String usuario;
    private String correo;
    private Integer perfilId;
    private Boolean activo;
}
