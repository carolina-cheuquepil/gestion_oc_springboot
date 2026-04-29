package com.carolina.gestion_oc_activos.domain.empresa.port;

import com.carolina.gestion_oc_activos.domain.empresa.model.DireccionDomain;

import java.util.List;
import java.util.Optional;

public interface DireccionRepositoryPort {

    DireccionDomain guardar(DireccionDomain direccion);

    List<DireccionDomain> listar();

    Optional<DireccionDomain> obtenerPorId(Integer id);

    void eliminar(Integer id);
}
