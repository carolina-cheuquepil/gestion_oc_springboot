package com.carolina.gestion_oc_activos.adapter.bd.proveedor.repository;

import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorContactoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorContactoRepository extends JpaRepository<ProveedorContactoEntity, Integer> {

    List<ProveedorContactoEntity> findByProveedor_ProveedorId(Integer proveedorId);
}
