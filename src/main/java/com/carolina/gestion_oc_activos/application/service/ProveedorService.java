package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorEntity;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.port.ProveedorRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    private final ProveedorRepositoryPort proveedorRepositoryPort;

    public ProveedorService(ProveedorRepositoryPort proveedorRepositoryPort) {
        this.proveedorRepositoryPort = proveedorRepositoryPort;
    }

    public ProveedorDomain guardar(ProveedorDomain empresa) {
        return proveedorRepositoryPort.guardar(empresa);
    }

    public List<ProveedorDomain> listar() {
        return proveedorRepositoryPort.listar();
    }

    public Optional<ProveedorDomain> obtenerPorId(Integer id) {
        return proveedorRepositoryPort.obtenerPorId(id);
    }

    public void eliminar(Integer id) {
        proveedorRepositoryPort.eliminar(id);
    }

}

// 08/04 Parte 07
