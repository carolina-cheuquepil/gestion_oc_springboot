package com.carolina.gestion_oc_activos.adapter.bd.ordencompra.repository;

import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.entity.OrdenCompraItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompraItemRepository extends JpaRepository<OrdenCompraItemEntity, Integer> {

    List<OrdenCompraItemEntity> findByOrdenCompraOcId(Integer ocId);
}
