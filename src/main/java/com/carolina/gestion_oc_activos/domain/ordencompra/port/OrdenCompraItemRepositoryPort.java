package com.carolina.gestion_oc_activos.domain.ordencompra.port;

import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraItemDomain;

import java.util.List;
import java.util.Optional;

public interface OrdenCompraItemRepositoryPort {

    OrdenCompraItemDomain guardar(OrdenCompraItemDomain item);

    List<OrdenCompraItemDomain> listarPorOc(Integer ocId);

    Optional<OrdenCompraItemDomain> obtenerPorId(Integer id);

    void eliminar(Integer id);
}
