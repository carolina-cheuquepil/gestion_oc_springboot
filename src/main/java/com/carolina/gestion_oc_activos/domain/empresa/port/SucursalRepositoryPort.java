package com.carolina.gestion_oc_activos.domain.empresa.port;

import com.carolina.gestion_oc_activos.domain.empresa.model.SucursalDomain;

import java.util.List;
import java.util.Optional;

public interface SucursalRepositoryPort {

    SucursalDomain guardar(SucursalDomain sucursal);

    List<SucursalDomain> listar();

    Optional<SucursalDomain> obtenerPorId(Integer id);

    List<SucursalDomain> listarPorEmpresa(Integer empresaId);

    void eliminar(Integer id);
}
