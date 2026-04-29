package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.CondicionCompraDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CondicionCompraRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicionCompraService {

    private final CondicionCompraRepositoryPort condicionCompraRepositoryPort;

    public CondicionCompraService(CondicionCompraRepositoryPort condicionCompraRepositoryPort) {
        this.condicionCompraRepositoryPort = condicionCompraRepositoryPort;
    }

    public List<CondicionCompraDomain> listar() {
        return condicionCompraRepositoryPort.listar();
    }

    public Optional<CondicionCompraDomain> obtenerPorId(Integer id) {
        return condicionCompraRepositoryPort.obtenerPorId(id);
    }
}
