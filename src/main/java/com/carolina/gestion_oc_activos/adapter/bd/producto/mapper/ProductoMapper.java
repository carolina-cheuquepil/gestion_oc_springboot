package com.carolina.gestion_oc_activos.adapter.bd.producto.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.MarcaEntity;
import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.ProductoEntity;
import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.TipoProductoEntity;
import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.UomEntity;
import com.carolina.gestion_oc_activos.domain.producto.model.MarcaDomain;
import com.carolina.gestion_oc_activos.domain.producto.model.ProductoDomain;
import com.carolina.gestion_oc_activos.domain.producto.model.TipoProductoDomain;
import com.carolina.gestion_oc_activos.domain.producto.model.UomDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoMapper {

    private final CatalogoMapper catalogoMapper;

    // ─── Marca ───────────────────────────────────────────────────────────────

    public MarcaDomain toDomain(MarcaEntity entity) {
        if (entity == null) return null;
        MarcaDomain domain = new MarcaDomain();
        domain.setMarcaId(entity.getMarcaId());
        domain.setMarcaNombre(entity.getMarcaNombre());
        return domain;
    }

    public MarcaEntity toEntity(MarcaDomain domain) {
        if (domain == null) return null;
        MarcaEntity entity = new MarcaEntity();
        entity.setMarcaId(domain.getMarcaId());
        entity.setMarcaNombre(domain.getMarcaNombre());
        return entity;
    }

    // ─── Uom ─────────────────────────────────────────────────────────────────

    public UomDomain toDomain(UomEntity entity) {
        if (entity == null) return null;
        UomDomain domain = new UomDomain();
        domain.setUomId(entity.getUomId());
        domain.setCodigo(entity.getCodigo());
        domain.setNombre(entity.getNombre());
        domain.setActivo(entity.getActivo());
        return domain;
    }

    public UomEntity toEntity(UomDomain domain) {
        if (domain == null) return null;
        UomEntity entity = new UomEntity();
        entity.setUomId(domain.getUomId());
        entity.setCodigo(domain.getCodigo());
        entity.setNombre(domain.getNombre());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    // ─── TipoProducto ─────────────────────────────────────────────────────────

    public TipoProductoDomain toDomain(TipoProductoEntity entity) {
        if (entity == null) return null;
        TipoProductoDomain domain = new TipoProductoDomain();
        domain.setTipoProductoId(entity.getTipoProductoId());
        domain.setCodigo(entity.getCodigo());
        domain.setNombre(entity.getNombre());
        domain.setActivo(entity.getActivo());
        return domain;
    }

    public TipoProductoEntity toEntity(TipoProductoDomain domain) {
        if (domain == null) return null;
        TipoProductoEntity entity = new TipoProductoEntity();
        entity.setTipoProductoId(domain.getTipoProductoId());
        entity.setCodigo(domain.getCodigo());
        entity.setNombre(domain.getNombre());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    // ─── Producto ─────────────────────────────────────────────────────────────

    public ProductoDomain toDomain(ProductoEntity entity) {
        if (entity == null) return null;
        ProductoDomain domain = new ProductoDomain();
        domain.setProductoId(entity.getProductoId());
        domain.setProductoNombre(entity.getProductoNombre());
        domain.setDescripcion(entity.getDescripcion());
        domain.setMarca(toDomain(entity.getMarca()));
        domain.setSku(entity.getSku());
        domain.setTipoProducto(toDomain(entity.getTipoProducto()));
        domain.setUom(toDomain(entity.getUom()));
        domain.setCuentaContable(catalogoMapper.toDomain(entity.getCuentaContable()));
        domain.setConceptoGasto(catalogoMapper.toDomain(entity.getConceptoGasto()));
        return domain;
    }

    public ProductoEntity toEntity(ProductoDomain domain) {
        if (domain == null) return null;
        ProductoEntity entity = new ProductoEntity();
        entity.setProductoId(domain.getProductoId());
        entity.setProductoNombre(domain.getProductoNombre());
        entity.setDescripcion(domain.getDescripcion());
        entity.setMarca(toEntity(domain.getMarca()));
        entity.setSku(domain.getSku());
        entity.setTipoProducto(toEntity(domain.getTipoProducto()));
        entity.setUom(toEntity(domain.getUom()));
        entity.setCuentaContable(catalogoMapper.toEntity(domain.getCuentaContable()));
        entity.setConceptoGasto(catalogoMapper.toEntity(domain.getConceptoGasto()));
        return entity;
    }
}
