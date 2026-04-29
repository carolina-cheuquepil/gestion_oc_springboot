package com.carolina.gestion_oc_activos.domain.ordencompra.model;

import com.carolina.gestion_oc_activos.domain.catalogo.model.*;
import com.carolina.gestion_oc_activos.domain.empresa.model.EmpresaDomain;
import com.carolina.gestion_oc_activos.domain.empresa.model.UsuarioDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorContactoDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorDomain;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrdenCompraDomain {

    private Integer ocId;
    private EmpresaDomain empresa;
    private TipoOCDomain tipoOc;
    private LocalDate fechaEmision;
    private UsuarioDomain usuarioSolicitante;
    private UsuarioDomain usuarioAprobador;
    private ProveedorDomain proveedor;
    private ProveedorContactoDomain proveedorContacto;
    private CondicionCompraDomain condicionCompra;
    private MonedaDomain moneda;
    private CentroGestionDomain centroGestion;
    private EstadoOcDomain estado;
    private CuentaContableDomain cuentaContable;
    private ConceptoGastoDomain conceptoGasto;
    private String observacion;
    private BigDecimal subtotal;
    private BigDecimal descuentoTotal;
    private BigDecimal impuestoTotal;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<OrdenCompraItemDomain> items = new ArrayList<>();
}
