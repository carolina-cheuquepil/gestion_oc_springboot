package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.MonedaRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.MonedaDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.MonedaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MonedaBdAdapter implements MonedaRepositoryPort {

    private final MonedaRepository monedaRepository;
    private final CatalogoMapper catalogoMapper;

    @Override
    public List<MonedaDomain> listar() {
        return monedaRepository.findAll()
                .stream()
                .map(catalogoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MonedaDomain> obtenerPorId(Integer id) {
        return monedaRepository.findById(id)
                .map(catalogoMapper::toDomain);
    }
}
