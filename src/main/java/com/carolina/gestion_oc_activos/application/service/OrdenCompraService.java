package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.port.CentroGestionRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CondicionCompraRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ConceptoGastoRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CuentaContableRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.EstadoOcRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.MonedaRepositoryPort;
import com.carolina.gestion_oc_activos.domain.catalogo.port.TipoOCRepositoryPort;
import com.carolina.gestion_oc_activos.domain.empresa.port.EmpresaRepositoryPort;
import com.carolina.gestion_oc_activos.domain.empresa.port.UsuarioRepositoryPort;
import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraDomain;
import com.carolina.gestion_oc_activos.domain.ordencompra.port.OrdenCompraRepositoryPort;
import com.carolina.gestion_oc_activos.domain.proveedor.port.ProveedorRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraService {

    private final OrdenCompraRepositoryPort ordenCompraRepositoryPort;
    private final EmpresaRepositoryPort empresaRepositoryPort;
    private final TipoOCRepositoryPort tipoOCRepositoryPort;
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final ProveedorRepositoryPort proveedorRepositoryPort;
    private final CondicionCompraRepositoryPort condicionCompraRepositoryPort;
    private final MonedaRepositoryPort monedaRepositoryPort;
    private final CentroGestionRepositoryPort centroGestionRepositoryPort;
    private final EstadoOcRepositoryPort estadoOcRepositoryPort;
    private final CuentaContableRepositoryPort cuentaContableRepositoryPort;
    private final ConceptoGastoRepositoryPort conceptoGastoRepositoryPort;

    public OrdenCompraService(OrdenCompraRepositoryPort ordenCompraRepositoryPort,
                              EmpresaRepositoryPort empresaRepositoryPort,
                              TipoOCRepositoryPort tipoOCRepositoryPort,
                              UsuarioRepositoryPort usuarioRepositoryPort,
                              ProveedorRepositoryPort proveedorRepositoryPort,
                              CondicionCompraRepositoryPort condicionCompraRepositoryPort,
                              MonedaRepositoryPort monedaRepositoryPort,
                              CentroGestionRepositoryPort centroGestionRepositoryPort,
                              EstadoOcRepositoryPort estadoOcRepositoryPort,
                              CuentaContableRepositoryPort cuentaContableRepositoryPort,
                              ConceptoGastoRepositoryPort conceptoGastoRepositoryPort) {
        this.ordenCompraRepositoryPort = ordenCompraRepositoryPort;
        this.empresaRepositoryPort = empresaRepositoryPort;
        this.tipoOCRepositoryPort = tipoOCRepositoryPort;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.proveedorRepositoryPort = proveedorRepositoryPort;
        this.condicionCompraRepositoryPort = condicionCompraRepositoryPort;
        this.monedaRepositoryPort = monedaRepositoryPort;
        this.centroGestionRepositoryPort = centroGestionRepositoryPort;
        this.estadoOcRepositoryPort = estadoOcRepositoryPort;
        this.cuentaContableRepositoryPort = cuentaContableRepositoryPort;
        this.conceptoGastoRepositoryPort = conceptoGastoRepositoryPort;
    }

    public OrdenCompraDomain guardar(OrdenCompraDomain ordenCompra) {
        validarEntidadesRequeridas(ordenCompra);
        return ordenCompraRepositoryPort.guardar(ordenCompra);
    }

    public List<OrdenCompraDomain> listar() {
        return ordenCompraRepositoryPort.listar();
    }

    public Optional<OrdenCompraDomain> obtenerPorId(Integer id) {
        return ordenCompraRepositoryPort.obtenerPorId(id);
    }

    public void eliminar(Integer id) {
        ordenCompraRepositoryPort.eliminar(id);
    }

    private void validarEntidadesRequeridas(OrdenCompraDomain oc) {
        if (oc.getEmpresa() == null || empresaRepositoryPort.obtenerPorId(oc.getEmpresa().getEmpresaId()).isEmpty()) {
            throw new IllegalArgumentException("Empresa no encontrada");
        }
        if (oc.getTipoOc() == null || tipoOCRepositoryPort.obtenerPorId(oc.getTipoOc().getTipoOcId()).isEmpty()) {
            throw new IllegalArgumentException("Tipo de OC no encontrado");
        }
        if (oc.getUsuarioSolicitante() == null || usuarioRepositoryPort.obtenerPorId(oc.getUsuarioSolicitante().getUsuarioId()).isEmpty()) {
            throw new IllegalArgumentException("Usuario solicitante no encontrado");
        }
        if (oc.getProveedor() == null || proveedorRepositoryPort.obtenerPorId(oc.getProveedor().getProveedorId()).isEmpty()) {
            throw new IllegalArgumentException("Proveedor no encontrado");
        }
        if (oc.getCondicionCompra() == null || condicionCompraRepositoryPort.obtenerPorId(oc.getCondicionCompra().getCondicionCompraId()).isEmpty()) {
            throw new IllegalArgumentException("Condición de compra no encontrada");
        }
        if (oc.getMoneda() == null || monedaRepositoryPort.obtenerPorId(oc.getMoneda().getMonedaId()).isEmpty()) {
            throw new IllegalArgumentException("Moneda no encontrada");
        }
        if (oc.getCentroGestion() == null || centroGestionRepositoryPort.obtenerPorId(oc.getCentroGestion().getCentroGestionId()).isEmpty()) {
            throw new IllegalArgumentException("Centro de gestión no encontrado");
        }
        if (oc.getEstado() == null || estadoOcRepositoryPort.obtenerPorId(oc.getEstado().getEstadoOcId()).isEmpty()) {
            throw new IllegalArgumentException("Estado de OC no encontrado");
        }
        if (oc.getCuentaContable() != null && cuentaContableRepositoryPort.obtenerPorId(oc.getCuentaContable().getCuentaId()).isEmpty()) {
            throw new IllegalArgumentException("Cuenta contable no encontrada");
        }
        if (oc.getConceptoGasto() != null && conceptoGastoRepositoryPort.obtenerPorId(oc.getConceptoGasto().getConceptoGastoId()).isEmpty()) {
            throw new IllegalArgumentException("Concepto de gasto no encontrado");
        }
    }
}
