package com.carolina.gestion_oc_activos.domain.producto.port;

import com.carolina.gestion_oc_activos.domain.producto.model.ProductoDomain;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    List<ProductoDomain> listar();
    Optional<ProductoDomain> obtenerPorId(Integer id);
    ProductoDomain guardar(ProductoDomain producto);
    void eliminar(Integer id);
    boolean existsBySku(String sku);
    boolean existsBySkuAndProductoIdNot(String sku, Integer id);
}
