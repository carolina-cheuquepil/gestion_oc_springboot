package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.CondicionCompraDomain;

import java.util.List;
import java.util.Optional;

public interface CondicionCompraRepositoryPort {

    List<CondicionCompraDomain> listar();

    Optional<CondicionCompraDomain> obtenerPorId(Integer id);
}
