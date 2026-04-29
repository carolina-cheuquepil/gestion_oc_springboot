package com.carolina.gestion_oc_activos.domain.producto.model;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ConceptoGastoDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.model.CuentaContableDomain;
import lombok.Data;

@Data
public class ProductoDomain {

    private Integer productoId;
    private String productoNombre;
    private String descripcion;
    private MarcaDomain marca;
    private String sku;
    private TipoProductoDomain tipoProducto;
    private UomDomain uom;
    private CuentaContableDomain cuentaContable;
    private ConceptoGastoDomain conceptoGasto;
}
