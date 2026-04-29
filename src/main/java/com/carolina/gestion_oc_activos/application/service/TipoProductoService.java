package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.producto.model.TipoProductoDomain;
import com.carolina.gestion_oc_activos.domain.producto.port.TipoProductoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProductoService {

    private final TipoProductoRepositoryPort tipoProductoRepositoryPort;

    public TipoProductoService(TipoProductoRepositoryPort tipoProductoRepositoryPort) {
        this.tipoProductoRepositoryPort = tipoProductoRepositoryPort;
    }

    public List<TipoProductoDomain> listar() {
        return tipoProductoRepositoryPort.listar();
    }

    public Optional<TipoProductoDomain> obtenerPorId(Integer id) {
        return tipoProductoRepositoryPort.obtenerPorId(id);
    }
}
