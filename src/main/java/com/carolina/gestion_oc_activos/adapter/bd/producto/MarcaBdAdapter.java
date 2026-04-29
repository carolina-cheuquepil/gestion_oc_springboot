package com.carolina.gestion_oc_activos.adapter.bd.producto;

import com.carolina.gestion_oc_activos.adapter.bd.producto.mapper.ProductoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.producto.repository.MarcaRepository;
import com.carolina.gestion_oc_activos.domain.producto.model.MarcaDomain;
import com.carolina.gestion_oc_activos.domain.producto.port.MarcaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MarcaBdAdapter implements MarcaRepositoryPort {

    private final MarcaRepository marcaRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<MarcaDomain> listar() {
        return marcaRepository.findAll()
                .stream()
                .map(productoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MarcaDomain> obtenerPorId(Integer id) {
        return marcaRepository.findById(id)
                .map(productoMapper::toDomain);
    }
}
