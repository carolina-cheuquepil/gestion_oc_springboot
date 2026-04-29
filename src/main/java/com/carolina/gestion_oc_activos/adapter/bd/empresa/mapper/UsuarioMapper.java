package com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.UsuarioEntity;
import com.carolina.gestion_oc_activos.domain.empresa.model.UsuarioDomain;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDomain toDomain(UsuarioEntity entity) {
        if (entity == null) return null;
        UsuarioDomain domain = new UsuarioDomain();
        domain.setUsuarioId(entity.getUsuarioId());
        domain.setNombre(entity.getNombre());
        domain.setApellido(entity.getApellido());
        domain.setUsuario(entity.getUsuario());
        domain.setCorreo(entity.getCorreo());
        domain.setPerfilId(entity.getPerfilId());
        domain.setActivo(entity.getActivo());
        return domain;
    }

    public UsuarioEntity toEntity(UsuarioDomain domain) {
        if (domain == null) return null;
        UsuarioEntity entity = new UsuarioEntity();
        entity.setUsuarioId(domain.getUsuarioId());
        entity.setNombre(domain.getNombre());
        entity.setApellido(domain.getApellido());
        entity.setUsuario(domain.getUsuario());
        entity.setCorreo(domain.getCorreo());
        entity.setPerfilId(domain.getPerfilId());
        entity.setActivo(domain.getActivo());
        return entity;
    }
}
