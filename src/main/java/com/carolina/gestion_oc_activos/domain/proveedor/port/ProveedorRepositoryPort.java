package com.carolina.gestion_oc_activos.domain.proveedor.port;

import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorDomain;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepositoryPort {

    ProveedorDomain guardar(ProveedorDomain proveedor);

    List<ProveedorDomain> listar();

    Optional<ProveedorDomain> obtenerPorId(Integer id);

    void eliminar(Integer id);
}

// 08/04 Parte 05 Inicio A
