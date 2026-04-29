package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.CuentaContableDomain;

import java.util.List;
import java.util.Optional;

public interface CuentaContableRepositoryPort {

    List<CuentaContableDomain> listar();

    Optional<CuentaContableDomain> obtenerPorId(Integer id);
}
