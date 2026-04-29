package com.carolina.gestion_oc_activos.adapter.bd.producto.repository;

import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.TipoProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProductoEntity, Integer> {
}
