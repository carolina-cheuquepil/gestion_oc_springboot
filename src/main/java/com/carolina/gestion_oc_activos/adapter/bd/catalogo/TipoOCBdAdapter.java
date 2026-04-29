package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.TipoOCRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.TipoOCDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.TipoOCRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TipoOCBdAdapter implements TipoOCRepositoryPort {

    private final TipoOCRepository tipoOCRepository;
    private final CatalogoMapper catalogoMapper;

    @Override
    public List<TipoOCDomain> listar() {
        return tipoOCRepository.findAll()
                .stream()
                .map(catalogoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TipoOCDomain> obtenerPorId(Integer id) {
        return tipoOCRepository.findById(id)
                .map(catalogoMapper::toDomain);
    }
}
