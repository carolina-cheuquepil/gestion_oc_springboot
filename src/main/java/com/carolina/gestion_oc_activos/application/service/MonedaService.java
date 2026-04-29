package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.MonedaDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.MonedaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaService {

    private final MonedaRepositoryPort monedaRepositoryPort;

    public MonedaService(MonedaRepositoryPort monedaRepositoryPort) {
        this.monedaRepositoryPort = monedaRepositoryPort;
    }

    public List<MonedaDomain> listar() {
        return monedaRepositoryPort.listar();
    }

    public Optional<MonedaDomain> obtenerPorId(Integer id) {
        return monedaRepositoryPort.obtenerPorId(id);
    }
}
