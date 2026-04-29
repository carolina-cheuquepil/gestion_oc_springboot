package com.carolina.gestion_oc_activos.domain.ordencompra.port;

import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraDomain;

import java.util.List;
import java.util.Optional;

public interface OrdenCompraRepositoryPort {

    OrdenCompraDomain guardar(OrdenCompraDomain ordenCompra);

    List<OrdenCompraDomain> listar();

    Optional<OrdenCompraDomain> obtenerPorId(Integer id);

    void eliminar(Integer id);
}
