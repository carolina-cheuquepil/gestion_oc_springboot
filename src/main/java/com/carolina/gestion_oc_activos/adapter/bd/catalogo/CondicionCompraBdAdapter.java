package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.CondicionCompraRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.CondicionCompraDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CondicionCompraRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CondicionCompraBdAdapter implements CondicionCompraRepositoryPort {

    private final CondicionCompraRepository condicionCompraRepository;
    private final CatalogoMapper catalogoMapper;

    @Override
    public List<CondicionCompraDomain> listar() {
        return condicionCompraRepository.findAll()
                .stream()
                .map(catalogoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CondicionCompraDomain> obtenerPorId(Integer id) {
        return condicionCompraRepository.findById(id)
                .map(catalogoMapper::toDomain);
    }
}
