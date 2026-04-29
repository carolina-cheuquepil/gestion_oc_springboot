package com.carolina.gestion_oc_activos.adapter.bd.producto;

import com.carolina.gestion_oc_activos.adapter.bd.producto.mapper.ProductoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.producto.repository.UomRepository;
import com.carolina.gestion_oc_activos.domain.producto.model.UomDomain;
import com.carolina.gestion_oc_activos.domain.producto.port.UomRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UomBdAdapter implements UomRepositoryPort {

    private final UomRepository uomRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<UomDomain> listar() {
        return uomRepository.findAll()
                .stream()
                .map(productoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UomDomain> obtenerPorId(Integer id) {
        return uomRepository.findById(id)
                .map(productoMapper::toDomain);
    }
}
