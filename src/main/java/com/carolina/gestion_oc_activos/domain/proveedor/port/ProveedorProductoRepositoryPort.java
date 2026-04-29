package com.carolina.gestion_oc_activos.domain.proveedor.port;

import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorProductoDomain;

import java.util.List;
import java.util.Optional;

public interface ProveedorProductoRepositoryPort {

    ProveedorProductoDomain guardar(ProveedorProductoDomain proveedorProducto);

    List<ProveedorProductoDomain> listar();

    Optional<ProveedorProductoDomain> obtenerPorId(Integer id);

    List<ProveedorProductoDomain> listarPorProveedor(Integer proveedorId);

    void eliminar(Integer id);
}
