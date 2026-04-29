package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ProyectoDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ProyectoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepositoryPort proyectoRepositoryPort;

    public ProyectoService(ProyectoRepositoryPort proyectoRepositoryPort) {
        this.proyectoRepositoryPort = proyectoRepositoryPort;
    }

    public List<ProyectoDomain> listar() {
        return proyectoRepositoryPort.listar();
    }

    public Optional<ProyectoDomain> obtenerPorId(Integer id) {
        return proyectoRepositoryPort.obtenerPorId(id);
    }
}
