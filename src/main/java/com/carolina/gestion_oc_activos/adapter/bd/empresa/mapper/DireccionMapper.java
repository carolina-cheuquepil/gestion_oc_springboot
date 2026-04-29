package com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.DireccionEntity;
import com.carolina.gestion_oc_activos.domain.empresa.model.DireccionDomain;
import org.springframework.stereotype.Component;

@Component
public class DireccionMapper {

    public DireccionDomain toDomain(DireccionEntity entity) {
        if (entity == null) return null;
        DireccionDomain domain = new DireccionDomain();
        domain.setDireccionId(entity.getDireccionId());
        domain.setCalle(entity.getCalle());
        domain.setNumero(entity.getNumero());
        domain.setCiudad(entity.getCiudad());
        domain.setComuna(entity.getComuna());
        domain.setRegion(entity.getRegion());
        return domain;
    }

    public DireccionEntity toEntity(DireccionDomain domain) {
        if (domain == null) return null;
        DireccionEntity entity = new DireccionEntity();
        entity.setDireccionId(domain.getDireccionId());
        entity.setCalle(domain.getCalle());
        entity.setNumero(domain.getNumero());
        entity.setCiudad(domain.getCiudad());
        entity.setComuna(domain.getComuna());
        entity.setRegion(domain.getRegion());
        return entity;
    }
}
