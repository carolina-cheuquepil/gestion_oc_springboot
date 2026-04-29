package com.carolina.gestion_oc_activos.adapter.bd.empresa.repository;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {
}
