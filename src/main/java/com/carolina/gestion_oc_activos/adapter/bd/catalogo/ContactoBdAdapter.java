package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.ContactoRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.ContactoDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ContactoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactoBdAdapter implements ContactoRepositoryPort {

    private final ContactoRepository contactoRepository;
    private final CatalogoMapper cataloMapper;

    @Override
    public ContactoDomain guardar(ContactoDomain contacto) {
        return cataloMapper.toDomain(contactoRepository.save(cataloMapper.toEntity(contacto)));
    }

    @Override
    public List<ContactoDomain> listar() {
        return contactoRepository.findAll().stream()
                .map(cataloMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ContactoDomain> obtenerPorId(Integer id) {
        return contactoRepository.findById(id).map(cataloMapper::toDomain);
    }

    @Override
    public void eliminar(Integer id) {
        contactoRepository.deleteById(id);
    }
}
