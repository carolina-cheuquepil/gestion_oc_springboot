package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorProductoDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.port.ProveedorProductoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorProductoService {

    private final ProveedorProductoRepositoryPort proveedorProductoRepositoryPort;

    public ProveedorProductoService(ProveedorProductoRepositoryPort proveedorProductoRepositoryPort) {
        this.proveedorProductoRepositoryPort = proveedorProductoRepositoryPort;
    }

    public ProveedorProductoDomain guardar(ProveedorProductoDomain proveedorProducto) {
        return proveedorProductoRepositoryPort.guardar(proveedorProducto);
    }

    public List<ProveedorProductoDomain> listar() {
        return proveedorProductoRepositoryPort.listar();
    }

    public Optional<ProveedorProductoDomain> obtenerPorId(Integer id) {
        return proveedorProductoRepositoryPort.obtenerPorId(id);
    }

    public List<ProveedorProductoDomain> listarPorProveedor(Integer proveedorId) {
        return proveedorProductoRepositoryPort.listarPorProveedor(proveedorId);
    }

    public void eliminar(Integer id) {
        proveedorProductoRepositoryPort.eliminar(id);
    }
}
