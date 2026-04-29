package com.carolina.gestion_oc_activos.adapter.bd.producto.repository;

import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.UomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UomRepository extends JpaRepository<UomEntity, Integer> {
}
