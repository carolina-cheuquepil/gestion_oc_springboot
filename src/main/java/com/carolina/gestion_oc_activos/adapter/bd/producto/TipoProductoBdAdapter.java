package com.carolina.gestion_oc_activos.adapter.bd.producto;

import com.carolina.gestion_oc_activos.adapter.bd.producto.mapper.ProductoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.producto.repository.TipoProductoRepository;
import com.carolina.gestion_oc_activos.domain.producto.model.TipoProductoDomain;
import com.carolina.gestion_oc_activos.domain.producto.port.TipoProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TipoProductoBdAdapter implements TipoProductoRepositoryPort {

    private final TipoProductoRepository tipoProductoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<TipoProductoDomain> listar() {
        return tipoProductoRepository.findAll()
                .stream()
                .map(productoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TipoProductoDomain> obtenerPorId(Integer id) {
        return tipoProductoRepository.findById(id)
                .map(productoMapper::toDomain);
    }
}
