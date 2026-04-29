package com.carolina.gestion_oc_activos.domain.empresa.port;

import com.carolina.gestion_oc_activos.domain.empresa.model.UsuarioDomain;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {

    List<UsuarioDomain> listar();

    Optional<UsuarioDomain> obtenerPorId(Integer id);
}
