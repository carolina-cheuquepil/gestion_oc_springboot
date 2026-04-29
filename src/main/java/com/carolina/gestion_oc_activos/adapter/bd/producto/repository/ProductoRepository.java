package com.carolina.gestion_oc_activos.adapter.bd.producto.repository;

import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    boolean existsBySku(String sku);

    boolean existsBySkuAndProductoIdNot(String sku, Integer productoId);
}
