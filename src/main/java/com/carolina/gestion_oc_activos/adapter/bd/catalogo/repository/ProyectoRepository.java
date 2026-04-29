package com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.ProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<ProyectoEntity, Integer> {
}
