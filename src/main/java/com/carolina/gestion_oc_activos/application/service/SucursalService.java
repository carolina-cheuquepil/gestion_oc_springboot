package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.empresa.model.SucursalDomain;
import com.carolina.gestion_oc_activos.domain.empresa.port.SucursalRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    private final SucursalRepositoryPort sucursalRepositoryPort;

    public SucursalService(SucursalRepositoryPort sucursalRepositoryPort) {
        this.sucursalRepositoryPort = sucursalRepositoryPort;
    }

    public SucursalDomain guardar(SucursalDomain sucursal) {
        return sucursalRepositoryPort.guardar(sucursal);
    }

    public List<SucursalDomain> listar() {
        return sucursalRepositoryPort.listar();
    }

    public Optional<SucursalDomain> obtenerPorId(Integer id) {
        return sucursalRepositoryPort.obtenerPorId(id);
    }

    public List<SucursalDomain> listarPorEmpresa(Integer empresaId) {
        return sucursalRepositoryPort.listarPorEmpresa(empresaId);
    }

    public void eliminar(Integer id) {
        sucursalRepositoryPort.eliminar(id);
    }
}
