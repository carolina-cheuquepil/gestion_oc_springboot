package com.carolina.gestion_oc_activos.adapter.bd.proveedor.repository;

import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorProductoRepository extends JpaRepository<ProveedorProductoEntity, Integer> {

    List<ProveedorProductoEntity> findByProveedor_ProveedorId(Integer proveedorId);
}
