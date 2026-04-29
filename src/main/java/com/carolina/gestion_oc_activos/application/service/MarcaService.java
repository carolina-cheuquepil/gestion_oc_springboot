package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.producto.model.MarcaDomain;
import com.carolina.gestion_oc_activos.domain.producto.port.MarcaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    private final MarcaRepositoryPort marcaRepositoryPort;

    public MarcaService(MarcaRepositoryPort marcaRepositoryPort) {
        this.marcaRepositoryPort = marcaRepositoryPort;
    }

    public List<MarcaDomain> listar() {
        return marcaRepositoryPort.listar();
    }

    public Optional<MarcaDomain> obtenerPorId(Integer id) {
        return marcaRepositoryPort.obtenerPorId(id);
    }
}
