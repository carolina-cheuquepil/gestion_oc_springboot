package com.carolina.gestion_oc_activos.adapter.bd.ordencompra.repository;

import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.entity.OrdenCompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompraEntity, Integer> {
}
