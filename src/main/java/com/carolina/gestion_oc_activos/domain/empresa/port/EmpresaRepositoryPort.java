package com.carolina.gestion_oc_activos.domain.empresa.port;

import com.carolina.gestion_oc_activos.domain.empresa.model.EmpresaDomain;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepositoryPort {

    EmpresaDomain guardar(EmpresaDomain empresa);

    List<EmpresaDomain> listar();

    Optional<EmpresaDomain> obtenerPorId(Integer id);

    void eliminar(Integer id);
}
