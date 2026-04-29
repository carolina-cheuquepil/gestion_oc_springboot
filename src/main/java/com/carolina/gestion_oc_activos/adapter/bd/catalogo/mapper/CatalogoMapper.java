package com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.*;
import com.carolina.gestion_oc_activos.domain.catalogo.model.*;
import org.springframework.stereotype.Component;

@Component
public class CatalogoMapper {

    // ─── CentroGestion ───────────────────────────────────────────────────────

    public CentroGestionDomain toDomain(CentroGestionEntity entity) {
        if (entity == null) return null;
        CentroGestionDomain domain = new CentroGestionDomain();
        domain.setCentroGestionId(entity.getCentroGestionId());
        domain.setCodigo(entity.getCodigo());
        domain.setNombre(entity.getNombre());
        domain.setActivo(entity.getActivo());
        return domain;
    }

    public CentroGestionEntity toEntity(CentroGestionDomain domain) {
        if (domain == null) return null;
        CentroGestionEntity entity = new CentroGestionEntity();
        entity.setCentroGestionId(domain.getCentroGestionId());
        entity.setCodigo(domain.getCodigo());
        entity.setNombre(domain.getNombre());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    // ─── CondicionCompra ─────────────────────────────────────────────────────

    public CondicionCompraDomain toDomain(CondicionCompraEntity entity) {
        if (entity == null) return null;
        CondicionCompraDomain domain = new CondicionCompraDomain();
        domain.setCondicionCompraId(entity.getCondicionCompraId());
        domain.setNombre(entity.getNombre());
        return domain;
    }

    public CondicionCompraEntity toEntity(CondicionCompraDomain domain) {
        if (domain == null) return null;
        CondicionCompraEntity entity = new CondicionCompraEntity();
        entity.setCondicionCompraId(domain.getCondicionCompraId());
        entity.setNombre(domain.getNombre());
        return entity;
    }

    // ─── Contacto ────────────────────────────────────────────────────────────

    public ContactoDomain toDomain(ContactoEntity entity) {
        if (entity == null) return null;
        ContactoDomain domain = new ContactoDomain();
        domain.setContactoId(entity.getContactoId());
        domain.setNombres(entity.getNombres());
        domain.setApellidos(entity.getApellidos());
        domain.setEmail(entity.getEmail());
        domain.setCelular(entity.getCelular());
        return domain;
    }

    public ContactoEntity toEntity(ContactoDomain domain) {
        if (domain == null) return null;
        ContactoEntity entity = new ContactoEntity();
        entity.setContactoId(domain.getContactoId());
        entity.setNombres(domain.getNombres());
        entity.setApellidos(domain.getApellidos());
        entity.setEmail(domain.getEmail());
        entity.setCelular(domain.getCelular());
        return entity;
    }

    // ─── EstadoOc ────────────────────────────────────────────────────────────

    public EstadoOcDomain toDomain(EstadoOcEntity entity) {
        if (entity == null) return null;
        EstadoOcDomain domain = new EstadoOcDomain();
        domain.setEstadoOcId(entity.getEstadoOcId());
        domain.setNombre(entity.getNombre());
        return domain;
    }

    public EstadoOcEntity toEntity(EstadoOcDomain domain) {
        if (domain == null) return null;
        EstadoOcEntity entity = new EstadoOcEntity();
        entity.setEstadoOcId(domain.getEstadoOcId());
        entity.setNombre(domain.getNombre());
        return entity;
    }

    // ─── Moneda ──────────────────────────────────────────────────────────────

    public MonedaDomain toDomain(MonedaEntity entity) {
        if (entity == null) return null;
        MonedaDomain domain = new MonedaDomain();
        domain.setMonedaId(entity.getMonedaId());
        domain.setCodigo(entity.getCodigo());
        domain.setNombre(entity.getNombre());
        return domain;
    }

    public MonedaEntity toEntity(MonedaDomain domain) {
        if (domain == null) return null;
        MonedaEntity entity = new MonedaEntity();
        entity.setMonedaId(domain.getMonedaId());
        entity.setCodigo(domain.getCodigo());
        entity.setNombre(domain.getNombre());
        return entity;
    }

    // ─── Proyecto ────────────────────────────────────────────────────────────

    public ProyectoDomain toDomain(ProyectoEntity entity) {
        if (entity == null) return null;
        ProyectoDomain domain = new ProyectoDomain();
        domain.setProyectoId(entity.getProyectoId());
        domain.setProyectoNombre(entity.getProyectoNombre());
        domain.setFechaInicio(entity.getFechaInicio());
        domain.setFechaTermino(entity.getFechaTermino());
        domain.setActivo(entity.getActivo());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        return domain;
    }

    public ProyectoEntity toEntity(ProyectoDomain domain) {
        if (domain == null) return null;
        ProyectoEntity entity = new ProyectoEntity();
        entity.setProyectoId(domain.getProyectoId());
        entity.setProyectoNombre(domain.getProyectoNombre());
        entity.setFechaInicio(domain.getFechaInicio());
        entity.setFechaTermino(domain.getFechaTermino());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    // ─── ConceptoGasto ───────────────────────────────────────────────────────

    public ConceptoGastoDomain toDomain(ConceptoGastoEntity entity) {
        if (entity == null) return null;
        ConceptoGastoDomain domain = new ConceptoGastoDomain();
        domain.setConceptoGastoId(entity.getConceptoGastoId());
        domain.setCodigo(entity.getCodigo());
        domain.setNombre(entity.getNombre());
        domain.setActivo(entity.getActivo());
        domain.setCreadoEn(entity.getCreadoEn());
        domain.setActualizadoEn(entity.getActualizadoEn());
        return domain;
    }

    public ConceptoGastoEntity toEntity(ConceptoGastoDomain domain) {
        if (domain == null) return null;
        ConceptoGastoEntity entity = new ConceptoGastoEntity();
        entity.setConceptoGastoId(domain.getConceptoGastoId());
        entity.setCodigo(domain.getCodigo());
        entity.setNombre(domain.getNombre());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    // ─── CuentaContable ──────────────────────────────────────────────────────

    public CuentaContableDomain toDomain(CuentaContableEntity entity) {
        if (entity == null) return null;
        CuentaContableDomain domain = new CuentaContableDomain();
        domain.setCuentaId(entity.getCuentaId());
        domain.setCodigo(entity.getCodigo());
        domain.setNombre(entity.getNombre());
        domain.setTipo(entity.getTipo());
        domain.setActivo(entity.getActivo());
        domain.setCreadoEn(entity.getCreadoEn());
        domain.setActualizadoEn(entity.getActualizadoEn());
        return domain;
    }

    public CuentaContableEntity toEntity(CuentaContableDomain domain) {
        if (domain == null) return null;
        CuentaContableEntity entity = new CuentaContableEntity();
        entity.setCuentaId(domain.getCuentaId());
        entity.setCodigo(domain.getCodigo());
        entity.setNombre(domain.getNombre());
        entity.setTipo(domain.getTipo());
        entity.setActivo(domain.getActivo());
        return entity;
    }

    // ─── TipoOC ──────────────────────────────────────────────────────────────

    public TipoOCDomain toDomain(TipoOCEntity entity) {
        if (entity == null) return null;
        TipoOCDomain domain = new TipoOCDomain();
        domain.setTipoOcId(entity.getTipoOcId());
        domain.setNombre(entity.getNombre());
        domain.setAfectaIva(entity.getAfectaIva());
        domain.setRequiereRetencion(entity.getRequiereRetencion());
        return domain;
    }

    public TipoOCEntity toEntity(TipoOCDomain domain) {
        if (domain == null) return null;
        TipoOCEntity entity = new TipoOCEntity();
        entity.setTipoOcId(domain.getTipoOcId());
        entity.setNombre(domain.getNombre());
        entity.setAfectaIva(domain.getAfectaIva());
        entity.setRequiereRetencion(domain.getRequiereRetencion());
        return entity;
    }
}
