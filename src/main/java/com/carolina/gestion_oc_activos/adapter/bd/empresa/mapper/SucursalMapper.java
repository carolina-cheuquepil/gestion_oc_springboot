package com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.SucursalEntity;
import com.carolina.gestion_oc_activos.domain.empresa.model.SucursalDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SucursalMapper {

    private final EmpresaMapper empresaMapper;
    private final DireccionMapper direccionMapper;

    public SucursalDomain toDomain(SucursalEntity entity) {
        if (entity == null) return null;
        SucursalDomain domain = new SucursalDomain();
        domain.setSucursalId(entity.getSucursalId());
        domain.setEmpresa(empresaMapper.toDomain(entity.getEmpresa()));
        domain.setCodigoSucursal(entity.getCodigoSucursal());
        domain.setNombre(entity.getNombre());
        domain.setActiva(entity.getActiva());
        domain.setDireccion(direccionMapper.toDomain(entity.getDireccion()));
        return domain;
    }

    public SucursalEntity toEntity(SucursalDomain domain) {
        if (domain == null) return null;
        SucursalEntity entity = new SucursalEntity();
        entity.setSucursalId(domain.getSucursalId());
        entity.setEmpresa(empresaMapper.toEntity(domain.getEmpresa()));
        entity.setCodigoSucursal(domain.getCodigoSucursal());
        entity.setNombre(domain.getNombre());
        entity.setActiva(domain.getActiva());
        entity.setDireccion(direccionMapper.toEntity(domain.getDireccion()));
        return entity;
    }
}
