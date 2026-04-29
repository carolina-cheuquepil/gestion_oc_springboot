package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.CentroGestionRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.CentroGestionDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CentroGestionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CentroGestionBdAdapter implements CentroGestionRepositoryPort {

    private final CentroGestionRepository centroGestionRepository;
    private final CatalogoMapper catalogoMapper;

    @Override
    public List<CentroGestionDomain> listar() {
        return centroGestionRepository.findAll()
                .stream()
                .map(catalogoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CentroGestionDomain> obtenerPorId(Integer id) {
        return centroGestionRepository.findById(id)
                .map(catalogoMapper::toDomain);
    }
}
