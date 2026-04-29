package com.carolina.gestion_oc_activos.adapter.bd.proveedor.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.producto.mapper.ProductoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorProductoEntity;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorProductoDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProveedorProductoMapper {

    private final ProveedorMapper proveedorMapper;
    private final ProductoMapper productoMapper;

    public ProveedorProductoDomain toDomain(ProveedorProductoEntity entity) {
        if (entity == null) return null;
        ProveedorProductoDomain domain = new ProveedorProductoDomain();
        domain.setProveedorProductoId(entity.getProveedorProductoId());
        domain.setProveedor(proveedorMapper.toDomain(entity.getProveedor()));
        domain.setProducto(productoMapper.toDomain(entity.getProducto()));
        return domain;
    }

    public ProveedorProductoEntity toEntity(ProveedorProductoDomain domain) {
        if (domain == null) return null;
        ProveedorProductoEntity entity = new ProveedorProductoEntity();
        entity.setProveedorProductoId(domain.getProveedorProductoId());
        entity.setProveedor(proveedorMapper.toEntity(domain.getProveedor()));
        entity.setProducto(productoMapper.toEntity(domain.getProducto()));
        return entity;
    }
}
