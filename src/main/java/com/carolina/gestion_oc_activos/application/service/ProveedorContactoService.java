package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorContactoDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.port.ProveedorContactoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorContactoService {

    private final ProveedorContactoRepositoryPort proveedorContactoRepositoryPort;

    public ProveedorContactoService(ProveedorContactoRepositoryPort proveedorContactoRepositoryPort) {
        this.proveedorContactoRepositoryPort = proveedorContactoRepositoryPort;
    }

    public ProveedorContactoDomain guardar(ProveedorContactoDomain proveedorContacto) {
        return proveedorContactoRepositoryPort.guardar(proveedorContacto);
    }

    public List<ProveedorContactoDomain> listar() {
        return proveedorContactoRepositoryPort.listar();
    }

    public Optional<ProveedorContactoDomain> obtenerPorId(Integer id) {
        return proveedorContactoRepositoryPort.obtenerPorId(id);
    }

    public List<ProveedorContactoDomain> listarPorProveedor(Integer proveedorId) {
        return proveedorContactoRepositoryPort.listarPorProveedor(proveedorId);
    }

    public void eliminar(Integer id) {
        proveedorContactoRepositoryPort.eliminar(id);
    }
}
