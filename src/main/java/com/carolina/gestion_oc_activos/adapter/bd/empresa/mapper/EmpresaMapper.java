package com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.EmpresaEntity;
import com.carolina.gestion_oc_activos.domain.empresa.model.EmpresaDomain;
import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper {
    public EmpresaDomain toDomain(EmpresaEntity entity) {
        if (entity == null) {
            return null;
        }

        EmpresaDomain domain = new EmpresaDomain();
        domain.setEmpresaId(entity.getEmpresaId());
        domain.setCodigoEmpresa(entity.getCodigoEmpresa());
        domain.setRazonSocial(entity.getRazonSocial());
        domain.setNombre(entity.getNombre());
        domain.setRutNumero(entity.getRutNumero());
        domain.setRutDv(entity.getRutDv());
        domain.setActiva(entity.getActiva());

        return domain;
    }

    public EmpresaEntity toEntity(EmpresaDomain domain) {
        if (domain == null) {
            return null;
        }

        EmpresaEntity entity = new EmpresaEntity();
        entity.setEmpresaId(domain.getEmpresaId());
        entity.setCodigoEmpresa(domain.getCodigoEmpresa());
        entity.setRazonSocial(domain.getRazonSocial());
        entity.setNombre(domain.getNombre());
        entity.setRutNumero(domain.getRutNumero());
        entity.setRutDv(domain.getRutDv());
        entity.setActiva(domain.getActiva());

        return entity;
    }
}
