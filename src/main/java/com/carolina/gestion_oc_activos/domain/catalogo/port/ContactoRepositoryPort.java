package com.carolina.gestion_oc_activos.domain.catalogo.port;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ContactoDomain;

import java.util.List;
import java.util.Optional;

public interface ContactoRepositoryPort {

    ContactoDomain guardar(ContactoDomain contacto);

    List<ContactoDomain> listar();

    Optional<ContactoDomain> obtenerPorId(Integer id);

    void eliminar(Integer id);
}
