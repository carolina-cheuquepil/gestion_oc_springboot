package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.MonedaDomain;

import java.util.List;
import java.util.Optional;

public interface MonedaRepositoryPort {

    List<MonedaDomain> listar();

    Optional<MonedaDomain> obtenerPorId(Integer id);
}
