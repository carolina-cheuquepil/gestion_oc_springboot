package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.CentroGestionDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CentroGestionRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CentroGestionService {

    private final CentroGestionRepositoryPort centroGestionRepositoryPort;

    public CentroGestionService(CentroGestionRepositoryPort centroGestionRepositoryPort) {
        this.centroGestionRepositoryPort = centroGestionRepositoryPort;
    }

    public List<CentroGestionDomain> listar() {
        return centroGestionRepositoryPort.listar();
    }

    public Optional<CentroGestionDomain> obtenerPorId(Integer id) {
        return centroGestionRepositoryPort.obtenerPorId(id);
    }
}
