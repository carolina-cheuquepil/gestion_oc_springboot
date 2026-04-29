package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.CuentaContableDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CuentaContableRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaContableService {

    private final CuentaContableRepositoryPort cuentaContableRepositoryPort;

    public CuentaContableService(CuentaContableRepositoryPort cuentaContableRepositoryPort) {
        this.cuentaContableRepositoryPort = cuentaContableRepositoryPort;
    }

    public List<CuentaContableDomain> listar() {
        return cuentaContableRepositoryPort.listar();
    }

    public Optional<CuentaContableDomain> obtenerPorId(Integer id) {
        return cuentaContableRepositoryPort.obtenerPorId(id);
    }
}
