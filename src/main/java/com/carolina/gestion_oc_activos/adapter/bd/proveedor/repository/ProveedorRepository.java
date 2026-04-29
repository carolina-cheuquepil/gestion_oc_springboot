package com.carolina.gestion_oc_activos.adapter.bd.proveedor.repository;

import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Integer> {
}
