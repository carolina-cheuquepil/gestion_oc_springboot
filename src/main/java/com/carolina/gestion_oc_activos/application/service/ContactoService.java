package com.carolina.gestion_oc_activos.application.service;

import com.carolina.gestion_oc_activos.domain.catalogo.model.ContactoDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ContactoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactoService {

    private final ContactoRepositoryPort contactoRepositoryPort;

    public ContactoDomain guardar(ContactoDomain contacto) {
        return contactoRepositoryPort.guardar(contacto);
    }

    public List<ContactoDomain> listar() {
        return contactoRepositoryPort.listar();
    }

    public Optional<ContactoDomain> obtenerPorId(Integer id) {
        return contactoRepositoryPort.obtenerPorId(id);
    }

    public void eliminar(Integer id) {
        contactoRepositoryPort.eliminar(id);
    }
}
