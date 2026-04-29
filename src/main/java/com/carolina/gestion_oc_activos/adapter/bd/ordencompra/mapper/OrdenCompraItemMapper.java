package com.carolina.gestion_oc_activos.adapter.bd.ordencompra.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.entity.OrdenCompraItemEntity;
import com.carolina.gestion_oc_activos.adapter.bd.producto.mapper.ProductoMapper;
import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraItemDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrdenCompraItemMapper {

    private final CatalogoMapper catalogoMapper;
    private final ProductoMapper productoMapper;

    public OrdenCompraItemDomain toDomain(OrdenCompraItemEntity entity) {
        if (entity == null) return null;
        OrdenCompraItemDomain domain = new OrdenCompraItemDomain();
        domain.setOcItemId(entity.getOcItemId());
        domain.setOcId(entity.getOrdenCompra().getOcId());
        domain.setNroLinea(entity.getNroLinea());
        domain.setProducto(productoMapper.toDomain(entity.getProducto()));
        domain.setDescripcion(entity.getDescripcion());
        domain.setCantidad(entity.getCantidad());
        domain.setPrecioUnitario(entity.getPrecioUnitario());
        domain.setDescuentoPorcentaje(entity.getDescuentoPorcentaje());
        domain.setAfectaIva(entity.getAfectaIva());
        domain.setIvaPorcentaje(entity.getIvaPorcentaje());
        domain.setSubtotalNeto(entity.getSubtotalNeto());
        domain.setSubtotalIva(entity.getSubtotalIva());
        domain.setSubtotalTotal(entity.getSubtotalTotal());
        domain.setProyecto(catalogoMapper.toDomain(entity.getProyecto()));
        domain.setCuentaContable(catalogoMapper.toDomain(entity.getCuentaContable()));
        domain.setConceptoGasto(catalogoMapper.toDomain(entity.getConceptoGasto()));
        domain.setObservacion(entity.getObservacion());
        domain.setCreadoEn(entity.getCreadoEn());
        domain.setActualizadoEn(entity.getActualizadoEn());
        return domain;
    }

    public OrdenCompraItemEntity toEntity(OrdenCompraItemDomain domain) {
        if (domain == null) return null;
        OrdenCompraItemEntity entity = new OrdenCompraItemEntity();
        entity.setOcItemId(domain.getOcItemId());
        entity.setNroLinea(domain.getNroLinea());
        entity.setProducto(productoMapper.toEntity(domain.getProducto()));
        entity.setDescripcion(domain.getDescripcion());
        entity.setCantidad(domain.getCantidad());
        entity.setPrecioUnitario(domain.getPrecioUnitario());
        entity.setDescuentoPorcentaje(domain.getDescuentoPorcentaje());
        entity.setAfectaIva(domain.getAfectaIva());
        entity.setIvaPorcentaje(domain.getIvaPorcentaje());
        entity.setSubtotalNeto(domain.getSubtotalNeto());
        entity.setSubtotalIva(domain.getSubtotalIva());
        entity.setSubtotalTotal(domain.getSubtotalTotal());
        entity.setProyecto(catalogoMapper.toEntity(domain.getProyecto()));
        entity.setCuentaContable(catalogoMapper.toEntity(domain.getCuentaContable()));
        entity.setConceptoGasto(catalogoMapper.toEntity(domain.getConceptoGasto()));
        entity.setObservacion(domain.getObservacion());
        return entity;
    }
}
