package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.CentroGestionDomain;

import java.util.List;
import java.util.Optional;

public interface CentroGestionRepositoryPort {

    List<CentroGestionDomain> listar();

    Optional<CentroGestionDomain> obtenerPorId(Integer id);
}
