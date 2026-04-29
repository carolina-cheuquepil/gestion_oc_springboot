package com.carolina.gestion_oc_activos.adapter.bd.producto.repository;

import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Integer> {
}
