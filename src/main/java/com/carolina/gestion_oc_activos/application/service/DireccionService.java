package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.empresa.model.DireccionDomain;
import com.carolina.gestion_oc_activos.domain.empresa.port.DireccionRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionService {

    private final DireccionRepositoryPort direccionRepositoryPort;

    public DireccionService(DireccionRepositoryPort direccionRepositoryPort) {
        this.direccionRepositoryPort = direccionRepositoryPort;
    }

    public DireccionDomain guardar(DireccionDomain direccion) {
        return direccionRepositoryPort.guardar(direccion);
    }

    public List<DireccionDomain> listar() {
        return direccionRepositoryPort.listar();
    }

    public Optional<DireccionDomain> obtenerPorId(Integer id) {
        return direccionRepositoryPort.obtenerPorId(id);
    }

    public void eliminar(Integer id) {
        direccionRepositoryPort.eliminar(id);
    }
}
