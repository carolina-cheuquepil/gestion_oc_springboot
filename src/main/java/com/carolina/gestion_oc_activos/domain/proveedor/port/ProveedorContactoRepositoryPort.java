package com.carolina.gestion_oc_activos.domain.proveedor.port;

import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorContactoDomain;

import java.util.List;
import java.util.Optional;

public interface ProveedorContactoRepositoryPort {

    ProveedorContactoDomain guardar(ProveedorContactoDomain proveedorContacto);

    List<ProveedorContactoDomain> listar();

    Optional<ProveedorContactoDomain> obtenerPorId(Integer id);

    List<ProveedorContactoDomain> listarPorProveedor(Integer proveedorId);

    void eliminar(Integer id);
}
