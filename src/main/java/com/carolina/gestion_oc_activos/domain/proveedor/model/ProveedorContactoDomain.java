package com.carolina.gestion_oc_activos.domain.proveedor.model;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ContactoDomain;
import lombok.Data;

@Data
public class ProveedorContactoDomain {

    private Integer proveedorContactoId;
    private ProveedorDomain proveedor;
    private ContactoDomain contacto;
    private Boolean esPrincipal;
    private Boolean activo;
}
