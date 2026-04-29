package com.carolina.gestion_oc_activos.domain.ordencompra.model;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ConceptoGastoDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.model.CuentaContableDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.model.ProyectoDomain;
import com.carolina.gestion_oc_activos.domain.producto.model.ProductoDomain;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrdenCompraItemDomain {

    private Integer ocItemId;
    private Integer ocId;
    private Integer nroLinea;
    private ProductoDomain producto;
    private String descripcion;
    private BigDecimal cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal descuentoPorcentaje;
    private Boolean afectaIva;
    private BigDecimal ivaPorcentaje;
    private BigDecimal subtotalNeto;
    private BigDecimal subtotalIva;
    private BigDecimal subtotalTotal;
    private ProyectoDomain proyecto;
    private CuentaContableDomain cuentaContable;
    private ConceptoGastoDomain conceptoGasto;
    private String observacion;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}
