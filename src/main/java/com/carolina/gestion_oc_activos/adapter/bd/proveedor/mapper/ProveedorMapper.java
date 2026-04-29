package com.carolina.gestion_oc_activos.adapter.bd.proveedor.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.EmpresaEntity;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorEntity;
import com.carolina.gestion_oc_activos.domain.empresa.model.EmpresaDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorDomain;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {
    public ProveedorDomain toDomain(ProveedorEntity entity) {
        if (entity == null) {
            return null;
        }

        ProveedorDomain domain = new ProveedorDomain();

        domain.setProveedorId(entity.getProveedorId());
        domain.setRazonSocial(entity.getRazonSocial());
        domain.setNombre(entity.getNombre());
        domain.setRutNumero(entity.getRutNumero());
        domain.setRutDv(entity.getRutDv());
        domain.setActiva(entity.getActiva());

        return domain;
    }

    public ProveedorEntity toEntity(ProveedorDomain domain) {
        if (domain == null) {
            return null;
        }

        ProveedorEntity entity = new ProveedorEntity();

        entity.setProveedorId(domain.getProveedorId());
        entity.setRazonSocial(domain.getRazonSocial());
        entity.setNombre(domain.getNombre());
        entity.setRutNumero(domain.getRutNumero());
        entity.setRutDv(domain.getRutDv());
        entity.setActiva(domain.getActiva());

        return entity;
    }
}
