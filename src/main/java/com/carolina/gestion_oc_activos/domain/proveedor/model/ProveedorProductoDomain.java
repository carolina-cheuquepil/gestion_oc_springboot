package com.carolina.gestion_oc_activos.domain.proveedor.model;

import com.carolina.gestion_oc_activos.domain.producto.model.ProductoDomain;
import lombok.Data;

@Data
public class ProveedorProductoDomain {

    private Integer proveedorProductoId;
    private ProveedorDomain proveedor;
    private ProductoDomain producto;
}
