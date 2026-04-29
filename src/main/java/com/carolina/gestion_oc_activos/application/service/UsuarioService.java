package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.empresa.model.UsuarioDomain;
import com.carolina.gestion_oc_activos.domain.empresa.port.UsuarioRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    public List<UsuarioDomain> listar() {
        return usuarioRepositoryPort.listar();
    }

    public Optional<UsuarioDomain> obtenerPorId(Integer id) {
        return usuarioRepositoryPort.obtenerPorId(id);
    }
}
