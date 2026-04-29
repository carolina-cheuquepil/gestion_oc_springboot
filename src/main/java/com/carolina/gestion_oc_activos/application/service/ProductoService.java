package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.port.ConceptoGastoRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CuentaContableRepositoryPort;
import com.carolina.gestion_oc_activos.domain.producto.model.ProductoDomain;
import com.carolina.gestion_oc_activos.domain.producto.port.MarcaRepositoryPort;
import com.carolina.gestion_oc_activos.domain.producto.port.ProductoRepositoryPort;
import com.carolina.gestion_oc_activos.domain.producto.port.TipoProductoRepositoryPort;
import com.carolina.gestion_oc_activos.domain.producto.port.UomRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepositoryPort productoRepositoryPort;
    private final TipoProductoRepositoryPort tipoProductoRepositoryPort;
    private final MarcaRepositoryPort marcaRepositoryPort;
    private final UomRepositoryPort uomRepositoryPort;
    private final CuentaContableRepositoryPort cuentaContableRepositoryPort;
    private final ConceptoGastoRepositoryPort conceptoGastoRepositoryPort;

    public ProductoService(ProductoRepositoryPort productoRepositoryPort,
                           TipoProductoRepositoryPort tipoProductoRepositoryPort,
                           MarcaRepositoryPort marcaRepositoryPort,
                           UomRepositoryPort uomRepositoryPort,
                           CuentaContableRepositoryPort cuentaContableRepositoryPort,
                           ConceptoGastoRepositoryPort conceptoGastoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
        this.tipoProductoRepositoryPort = tipoProductoRepositoryPort;
        this.marcaRepositoryPort = marcaRepositoryPort;
        this.uomRepositoryPort = uomRepositoryPort;
        this.cuentaContableRepositoryPort = cuentaContableRepositoryPort;
        this.conceptoGastoRepositoryPort = conceptoGastoRepositoryPort;
    }

    public List<ProductoDomain> listar() {
        return productoRepositoryPort.listar();
    }

    public Optional<ProductoDomain> obtenerPorId(Integer id) {
        return productoRepositoryPort.obtenerPorId(id);
    }

    public ProductoDomain guardar(ProductoDomain producto) {
        validar(producto);
        return productoRepositoryPort.guardar(producto);
    }

    public void eliminar(Integer id) {
        if (productoRepositoryPort.obtenerPorId(id).isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado con id: " + id);
        }
        productoRepositoryPort.eliminar(id);
    }

    private void validar(ProductoDomain producto) {
        if (producto.getProductoNombre() == null || producto.getProductoNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        if (producto.getSku() == null || producto.getSku().isBlank()) {
            throw new IllegalArgumentException("El SKU es obligatorio");
        }

        boolean skuDuplicado = producto.getProductoId() == null
                ? productoRepositoryPort.existsBySku(producto.getSku())
                : productoRepositoryPort.existsBySkuAndProductoIdNot(producto.getSku(), producto.getProductoId());
        if (skuDuplicado) {
            throw new IllegalArgumentException("Ya existe un producto con el SKU: " + producto.getSku());
        }

        if (producto.getTipoProducto() == null || producto.getTipoProducto().getTipoProductoId() == null) {
            throw new IllegalArgumentException("El tipo de producto es obligatorio");
        }
        if (tipoProductoRepositoryPort.obtenerPorId(producto.getTipoProducto().getTipoProductoId()).isEmpty()) {
            throw new IllegalArgumentException("Tipo de producto no encontrado con id: " + producto.getTipoProducto().getTipoProductoId());
        }

        if (producto.getMarca() != null && producto.getMarca().getMarcaId() != null
                && marcaRepositoryPort.obtenerPorId(producto.getMarca().getMarcaId()).isEmpty()) {
            throw new IllegalArgumentException("Marca no encontrada con id: " + producto.getMarca().getMarcaId());
        }

        if (producto.getUom() != null && producto.getUom().getUomId() != null
                && uomRepositoryPort.obtenerPorId(producto.getUom().getUomId()).isEmpty()) {
            throw new IllegalArgumentException("Unidad de medida no encontrada con id: " + producto.getUom().getUomId());
        }

        if (producto.getCuentaContable() != null && producto.getCuentaContable().getCuentaId() != null
                && cuentaContableRepositoryPort.obtenerPorId(producto.getCuentaContable().getCuentaId()).isEmpty()) {
            throw new IllegalArgumentException("Cuenta contable no encontrada con id: " + producto.getCuentaContable().getCuentaId());
        }

        if (producto.getConceptoGasto() != null && producto.getConceptoGasto().getConceptoGastoId() != null
                && conceptoGastoRepositoryPort.obtenerPorId(producto.getConceptoGasto().getConceptoGastoId()).isEmpty()) {
            throw new IllegalArgumentException("Concepto de gasto no encontrado con id: " + producto.getConceptoGasto().getConceptoGastoId());
        }
    }
}
