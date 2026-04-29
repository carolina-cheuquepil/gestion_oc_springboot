package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.ProyectoRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.ProyectoDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ProyectoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProyectoBdAdapter implements ProyectoRepositoryPort {

    private final ProyectoRepository proyectoRepository;
    private final CatalogoMapper catalogoMapper;

    @Override
    public List<ProyectoDomain> listar() {
        return proyectoRepository.findAll()
                .stream()
                .map(catalogoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProyectoDomain> obtenerPorId(Integer id) {
        return proyectoRepository.findById(id)
                .map(catalogoMapper::toDomain);
    }
}
