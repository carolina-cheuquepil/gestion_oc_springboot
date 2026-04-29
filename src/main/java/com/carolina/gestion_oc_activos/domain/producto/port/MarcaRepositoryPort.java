package com.carolina.gestion_oc_activos.domain.producto.port;

import com.carolina.gestion_oc_activos.domain.producto.model.MarcaDomain;

import java.util.List;
import java.util.Optional;

public interface MarcaRepositoryPort {
    List<MarcaDomain> listar();
    Optional<MarcaDomain> obtenerPorId(Integer id);
}
