package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.EstadoOcDomain;

import java.util.List;
import java.util.Optional;

public interface EstadoOcRepositoryPort {

    List<EstadoOcDomain> listar();

    Optional<EstadoOcDomain> obtenerPorId(Integer id);
}
