package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.EstadoOcRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.EstadoOcDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.EstadoOcRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EstadoOcBdAdapter implements EstadoOcRepositoryPort {

    private final EstadoOcRepository estadoOcRepository;
    private final CatalogoMapper catalogoMapper;

    @Override
    public List<EstadoOcDomain> listar() {
        return estadoOcRepository.findAll()
                .stream()
                .map(catalogoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EstadoOcDomain> obtenerPorId(Integer id) {
        return estadoOcRepository.findById(id)
                .map(catalogoMapper::toDomain);
    }
}
