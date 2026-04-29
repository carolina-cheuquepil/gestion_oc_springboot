package com.carolina.gestion_oc_activos.adapter.bd.empresa.repository;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
}
