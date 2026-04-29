package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.ConceptoGastoRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.ConceptoGastoDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.ConceptoGastoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConceptoGastoBdAdapter implements ConceptoGastoRepositoryPort {

    private final ConceptoGastoRepository conceptoGastoRepository;
    private final CatalogoMapper catalogoMapper;

    @Override
    public List<ConceptoGastoDomain> listar() {
        return conceptoGastoRepository.findAll()
                .stream()
                .map(catalogoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ConceptoGastoDomain> obtenerPorId(Integer id) {
        return conceptoGastoRepository.findById(id)
                .map(catalogoMapper::toDomain);
    }
}
