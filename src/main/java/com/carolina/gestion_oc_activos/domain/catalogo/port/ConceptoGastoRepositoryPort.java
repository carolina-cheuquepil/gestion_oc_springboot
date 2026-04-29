package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ConceptoGastoDomain;

import java.util.List;
import java.util.Optional;

public interface ConceptoGastoRepositoryPort {

    List<ConceptoGastoDomain> listar();

    Optional<ConceptoGastoDomain> obtenerPorId(Integer id);
}
