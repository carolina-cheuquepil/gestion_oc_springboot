package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.port.CuentaContableRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ConceptoGastoRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ProyectoRepositoryPort;
import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraItemDomain;
import com.carolina.gestion_oc_activos.domain.ordencompra.port.OrdenCompraItemRepositoryPort;
import com.carolina.gestion_oc_activos.domain.ordencompra.port.OrdenCompraRepositoryPort;
import com.carolina.gestion_oc_activos.domain.producto.port.ProductoRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraItemService {

    private final OrdenCompraItemRepositoryPort itemRepositoryPort;
    private final OrdenCompraRepositoryPort ordenCompraRepositoryPort;
    private final ProductoRepositoryPort productoRepositoryPort;
    private final CuentaContableRepositoryPort cuentaContableRepositoryPort;
    private final ConceptoGastoRepositoryPort conceptoGastoRepositoryPort;
    private final ProyectoRepositoryPort proyectoRepositoryPort;

    public OrdenCompraItemService(OrdenCompraItemRepositoryPort itemRepositoryPort,
                                  OrdenCompraRepositoryPort ordenCompraRepositoryPort,
                                  ProductoRepositoryPort productoRepositoryPort,
                                  CuentaContableRepositoryPort cuentaContableRepositoryPort,
                                  ConceptoGastoRepositoryPort conceptoGastoRepositoryPort,
                                  ProyectoRepositoryPort proyectoRepositoryPort) {
        this.itemRepositoryPort = itemRepositoryPort;
        this.ordenCompraRepositoryPort = ordenCompraRepositoryPort;
        this.productoRepositoryPort = productoRepositoryPort;
        this.cuentaContableRepositoryPort = cuentaContableRepositoryPort;
        this.conceptoGastoRepositoryPort = conceptoGastoRepositoryPort;
        this.proyectoRepositoryPort = proyectoRepositoryPort;
    }

    public OrdenCompraItemDomain guardar(Integer ocId, OrdenCompraItemDomain item) {
        if (ordenCompraRepositoryPort.obtenerPorId(ocId).isEmpty()) {
            throw new IllegalArgumentException("Orden de compra no encontrada con id: " + ocId);
        }

        if (item.getProducto() != null && item.getProducto().getProductoId() != null &&
                productoRepositoryPort.obtenerPorId(item.getProducto().getProductoId()).isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado con id: " + item.getProducto().getProductoId());
        }

        if (item.getCuentaContable() != null && item.getCuentaContable().getCuentaId() != null &&
                cuentaContableRepositoryPort.obtenerPorId(item.getCuentaContable().getCuentaId()).isEmpty()) {
            throw new IllegalArgumentException("Cuenta contable no encontrada");
        }

        if (item.getConceptoGasto() != null && item.getConceptoGasto().getConceptoGastoId() != null &&
                conceptoGastoRepositoryPort.obtenerPorId(item.getConceptoGasto().getConceptoGastoId()).isEmpty()) {
            throw new IllegalArgumentException("Concepto de gasto no encontrado");
        }

        if (item.getProyecto() != null && item.getProyecto().getProyectoId() != null &&
                proyectoRepositoryPort.obtenerPorId(item.getProyecto().getProyectoId()).isEmpty()) {
            throw new IllegalArgumentException("Proyecto no encontrado");
        }

        item.setOcId(ocId);

        if (item.getNroLinea() == null) {
            int siguiente = itemRepositoryPort.listarPorOc(ocId).size() + 1;
            item.setNroLinea(siguiente);
        }

        BigDecimal descuento = item.getDescuentoPorcentaje() != null ? item.getDescuentoPorcentaje() : BigDecimal.ZERO;
        item.setDescuentoPorcentaje(descuento);

        Boolean afectaIva = item.getAfectaIva() != null ? item.getAfectaIva() : Boolean.TRUE;
        item.setAfectaIva(afectaIva);

        BigDecimal ivaPorcentaje = item.getIvaPorcentaje() != null ? item.getIvaPorcentaje() : new BigDecimal("19.00");
        item.setIvaPorcentaje(ivaPorcentaje);

        BigDecimal subtotalNeto = item.getCantidad()
                .multiply(item.getPrecioUnitario())
                .multiply(BigDecimal.ONE.subtract(descuento.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)))
                .setScale(2, RoundingMode.HALF_UP);
        item.setSubtotalNeto(subtotalNeto);

        BigDecimal subtotalIva = afectaIva
                ? subtotalNeto.multiply(ivaPorcentaje.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP))
                        .setScale(2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO.setScale(2);
        item.setSubtotalIva(subtotalIva);

        item.setSubtotalTotal(subtotalNeto.add(subtotalIva));

        return itemRepositoryPort.guardar(item);
    }

    public List<OrdenCompraItemDomain> listarPorOc(Integer ocId) {
        return itemRepositoryPort.listarPorOc(ocId);
    }

    public Optional<OrdenCompraItemDomain> obtenerPorId(Integer id) {
        return itemRepositoryPort.obtenerPorId(id);
    }

    public void eliminar(Integer id) {
        itemRepositoryPort.eliminar(id);
    }
}
