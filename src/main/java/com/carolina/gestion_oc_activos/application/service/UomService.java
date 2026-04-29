package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.producto.model.UomDomain;
import com.carolina.gestion_oc_activos.domain.producto.port.UomRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UomService {

    private final UomRepositoryPort uomRepositoryPort;

    public UomService(UomRepositoryPort uomRepositoryPort) {
        this.uomRepositoryPort = uomRepositoryPort;
    }

    public List<UomDomain> listar() {
        return uomRepositoryPort.listar();
    }

    public Optional<UomDomain> obtenerPorId(Integer id) {
        return uomRepositoryPort.obtenerPorId(id);
    }
}
