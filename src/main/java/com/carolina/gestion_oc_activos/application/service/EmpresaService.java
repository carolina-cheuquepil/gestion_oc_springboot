package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.empresa.model.EmpresaDomain;
import com.carolina.gestion_oc_activos.domain.empresa.port.EmpresaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaRepositoryPort empresaRepositoryPort;

    public EmpresaService(EmpresaRepositoryPort empresaRepositoryPort) {
        this.empresaRepositoryPort = empresaRepositoryPort;
    }

    public EmpresaDomain guardar(EmpresaDomain empresa) {
        return empresaRepositoryPort.guardar(empresa);
    }

    public List<EmpresaDomain> listar() {
        return empresaRepositoryPort.listar();
    }

    public Optional<EmpresaDomain> obtenerPorId(Integer id) {
        return empresaRepositoryPort.obtenerPorId(id);
    }

    public void eliminar(Integer id) {
        empresaRepositoryPort.eliminar(id);
    }
}
