package com.carolina.gestion_oc_activos.adapter.bd.ordencompra.mapper;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper.EmpresaMapper;
import com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper.UsuarioMapper;
import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.entity.OrdenCompraEntity;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.mapper.ProveedorContactoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.mapper.ProveedorMapper;
import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrdenCompraMapper {

    private final EmpresaMapper empresaMapper;
    private final UsuarioMapper usuarioMapper;
    private final ProveedorMapper proveedorMapper;
    private final ProveedorContactoMapper proveedorContactoMapper;
    private final CatalogoMapper cataloMapper;
    private final OrdenCompraItemMapper itemMapper;

    public OrdenCompraDomain toDomain(OrdenCompraEntity entity) {
        if (entity == null) return null;
        OrdenCompraDomain domain = new OrdenCompraDomain();
        domain.setOcId(entity.getOcId());
        domain.setEmpresa(empresaMapper.toDomain(entity.getEmpresa()));
        domain.setTipoOc(cataloMapper.toDomain(entity.getTipoOc()));
        domain.setFechaEmision(entity.getFechaEmision());
        domain.setUsuarioSolicitante(usuarioMapper.toDomain(entity.getUsuarioSolicitante()));
        domain.setUsuarioAprobador(usuarioMapper.toDomain(entity.getUsuarioAprobador()));
        domain.setProveedor(proveedorMapper.toDomain(entity.getProveedor()));
        domain.setProveedorContacto(proveedorContactoMapper.toDomain(entity.getProveedorContacto()));
        domain.setCondicionCompra(cataloMapper.toDomain(entity.getCondicionCompra()));
        domain.setMoneda(cataloMapper.toDomain(entity.getMoneda()));
        domain.setCentroGestion(cataloMapper.toDomain(entity.getCentroGestion()));
        domain.setEstado(cataloMapper.toDomain(entity.getEstado()));
        domain.setCuentaContable(cataloMapper.toDomain(entity.getCuentaContable()));
        domain.setConceptoGasto(cataloMapper.toDomain(entity.getConceptoGasto()));
        domain.setObservacion(entity.getObservacion());
        domain.setSubtotal(entity.getSubtotal());
        domain.setDescuentoTotal(entity.getDescuentoTotal());
        domain.setImpuestoTotal(entity.getImpuestoTotal());
        domain.setTotal(entity.getTotal());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        domain.setItems(entity.getItems() != null
                ? entity.getItems().stream().map(itemMapper::toDomain).collect(Collectors.toList())
                : new ArrayList<>());
        return domain;
    }

    public OrdenCompraEntity toEntity(OrdenCompraDomain domain) {
        if (domain == null) return null;
        OrdenCompraEntity entity = new OrdenCompraEntity();
        entity.setOcId(domain.getOcId());
        entity.setEmpresa(empresaMapper.toEntity(domain.getEmpresa()));
        entity.setTipoOc(cataloMapper.toEntity(domain.getTipoOc()));
        entity.setFechaEmision(domain.getFechaEmision());
        entity.setUsuarioSolicitante(usuarioMapper.toEntity(domain.getUsuarioSolicitante()));
        entity.setUsuarioAprobador(usuarioMapper.toEntity(domain.getUsuarioAprobador()));
        entity.setProveedor(proveedorMapper.toEntity(domain.getProveedor()));
        entity.setProveedorContacto(proveedorContactoMapper.toEntity(domain.getProveedorContacto()));
        entity.setCondicionCompra(cataloMapper.toEntity(domain.getCondicionCompra()));
        entity.setMoneda(cataloMapper.toEntity(domain.getMoneda()));
        entity.setCentroGestion(cataloMapper.toEntity(domain.getCentroGestion()));
        entity.setEstado(cataloMapper.toEntity(domain.getEstado()));
        entity.setCuentaContable(cataloMapper.toEntity(domain.getCuentaContable()));
        entity.setConceptoGasto(cataloMapper.toEntity(domain.getConceptoGasto()));
        entity.setObservacion(domain.getObservacion());
        entity.setSubtotal(domain.getSubtotal() != null ? domain.getSubtotal() : java.math.BigDecimal.ZERO);
        entity.setDescuentoTotal(domain.getDescuentoTotal() != null ? domain.getDescuentoTotal() : java.math.BigDecimal.ZERO);
        entity.setImpuestoTotal(domain.getImpuestoTotal() != null ? domain.getImpuestoTotal() : java.math.BigDecimal.ZERO);
        entity.setTotal(domain.getTotal() != null ? domain.getTotal() : java.math.BigDecimal.ZERO);
        return entity;
    }
}
