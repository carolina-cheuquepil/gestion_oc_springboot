package com.carolina.gestion_oc_activos.adapter.bd.producto;

import com.carolina.gestion_oc_activos.adapter.bd.producto.mapper.ProductoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.producto.repository.ProductoRepository;
import com.carolina.gestion_oc_activos.domain.producto.model.ProductoDomain;
import com.carolina.gestion_oc_activos.domain.producto.port.ProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductoBdAdapter implements ProductoRepositoryPort {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoDomain> listar() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoDomain> obtenerPorId(Integer id) {
        return productoRepository.findById(id)
                .map(productoMapper::toDomain);
    }

    @Override
    public ProductoDomain guardar(ProductoDomain producto) {
        return productoMapper.toDomain(
                productoRepository.save(productoMapper.toEntity(producto))
        );
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public boolean existsBySku(String sku) {
        return productoRepository.existsBySku(sku);
    }

    @Override
    public boolean existsBySkuAndProductoIdNot(String sku, Integer id) {
        return productoRepository.existsBySkuAndProductoIdNot(sku, id);
    }
}
