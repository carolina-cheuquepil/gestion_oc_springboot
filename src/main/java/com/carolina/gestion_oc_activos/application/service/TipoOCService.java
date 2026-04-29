package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.TipoOCDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.TipoOCRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoOCService {

    private final TipoOCRepositoryPort tipoOCRepositoryPort;

    public TipoOCService(TipoOCRepositoryPort tipoOCRepositoryPort) {
        this.tipoOCRepositoryPort = tipoOCRepositoryPort;
    }

    public List<TipoOCDomain> listar() {
        return tipoOCRepositoryPort.listar();
    }

    public Optional<TipoOCDomain> obtenerPorId(Integer id) {
        return tipoOCRepositoryPort.obtenerPorId(id);
    }
}
