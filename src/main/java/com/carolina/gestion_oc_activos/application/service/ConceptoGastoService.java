package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ConceptoGastoDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ConceptoGastoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptoGastoService {

    private final ConceptoGastoRepositoryPort conceptoGastoRepositoryPort;

    public ConceptoGastoService(ConceptoGastoRepositoryPort conceptoGastoRepositoryPort) {
        this.conceptoGastoRepositoryPort = conceptoGastoRepositoryPort;
    }

    public List<ConceptoGastoDomain> listar() {
        return conceptoGastoRepositoryPort.listar();
    }

    public Optional<ConceptoGastoDomain> obtenerPorId(Integer id) {
        return conceptoGastoRepositoryPort.obtenerPorId(id);
    }
}
