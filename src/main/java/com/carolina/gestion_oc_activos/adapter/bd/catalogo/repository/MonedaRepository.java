package com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.MonedaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends JpaRepository<MonedaEntity, Integer> {
}
