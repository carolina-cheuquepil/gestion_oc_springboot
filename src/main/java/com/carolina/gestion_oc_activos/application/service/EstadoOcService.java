package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.EstadoOcDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.EstadoOcRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoOcService {

    private final EstadoOcRepositoryPort estadoOcRepositoryPort;

    public EstadoOcService(EstadoOcRepositoryPort estadoOcRepositoryPort) {
        this.estadoOcRepositoryPort = estadoOcRepositoryPort;
    }

    public List<EstadoOcDomain> listar() {
        return estadoOcRepositoryPort.listar();
    }

    public Optional<EstadoOcDomain> obtenerPorId(Integer id) {
        return estadoOcRepositoryPort.obtenerPorId(id);
    }
}
