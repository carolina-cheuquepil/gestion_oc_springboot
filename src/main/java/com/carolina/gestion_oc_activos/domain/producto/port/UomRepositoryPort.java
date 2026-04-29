package com.carolina.gestion_oc_activos.domain.producto.port;

import com.carolina.gestion_oc_activos.domain.producto.model.UomDomain;

import java.util.List;
import java.util.Optional;

public interface UomRepositoryPort {
    List<UomDomain> listar();
    Optional<UomDomain> obtenerPorId(Integer id);
}
