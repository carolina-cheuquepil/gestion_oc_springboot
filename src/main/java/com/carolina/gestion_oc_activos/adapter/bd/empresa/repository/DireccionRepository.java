package com.carolina.gestion_oc_activos.adapter.bd.empresa.repository;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer> {
}
