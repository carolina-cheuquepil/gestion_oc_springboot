package com.carolina.gestion_oc_activos.adapter.bd.empresa.repository;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity, Integer> {

    List<SucursalEntity> findByEmpresaEmpresaId(Integer empresaId);
}
