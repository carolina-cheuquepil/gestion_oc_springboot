package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ProyectoDomain;

import java.util.List;
import java.util.Optional;

public interface ProyectoRepositoryPort {

    List<ProyectoDomain> listar();

    Optional<ProyectoDomain> obtenerPorId(Integer id);
}
