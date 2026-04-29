package com.carolina.gestion_oc_activos.domain.producto.port;

import com.carolina.gestion_oc_activos.domain.producto.model.TipoProductoDomain;

import java.util.List;
import java.util.Optional;

public interface TipoProductoRepositoryPort {
    List<TipoProductoDomain> listar();
    Optional<TipoProductoDomain> obtenerPorId(Integer id);
}
