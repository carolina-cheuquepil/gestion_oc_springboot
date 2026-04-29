package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.TipoOCDomain;

import java.util.List;
import java.util.Optional;

public interface TipoOCRepositoryPort {

    List<TipoOCDomain> listar();

    Optional<TipoOCDomain> obtenerPorId(Integer id);
}
