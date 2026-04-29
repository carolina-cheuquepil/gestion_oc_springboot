package com.carolina.gestion_oc_activos.adapter.bd.proveedor.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorContactoEntity;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorContactoDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProveedorContactoMapper {

    private final ProveedorMapper proveedorMapper;
    private final CatalogoMapper cataloMapper;

    public ProveedorContactoDomain toDomain(ProveedorContactoEntity entity) {
        if (entity == null) return null;
        ProveedorContactoDomain domain = new ProveedorContactoDomain();
        domain.setProveedorContactoId(entity.getProveedorContactoId());
        domain.setProveedor(proveedorMapper.toDomain(entity.getProveedor()));
        domain.setContacto(cataloMapper.toDomain(entity.getContacto()));
        domain.setEsPrincipal(entity.getEsPrincipal());
        domain.setActivo(entity.getActivo());
        return domain;
    }

    public ProveedorContactoEntity toEntity(ProveedorContactoDomain domain) {
        if (domain == null) return null;
        ProveedorContactoEntity entity = new ProveedorContactoEntity();
        entity.setProveedorContactoId(domain.getProveedorContactoId());
        entity.setProveedor(proveedorMapper.toEntity(domain.getProveedor()));
        entity.setContacto(cataloMapper.toEntity(domain.getContacto()));
        entity.setEsPrincipal(domain.getEsPrincipal());
        entity.setActivo(domain.getActivo());
        return entity;
    }
}
