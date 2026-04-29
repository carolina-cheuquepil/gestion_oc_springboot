package com.carolina.gestion_oc_activos.adapter.bd.proveedor;

import com.carolina.gestion_oc_activos.adapter.bd.proveedor.mapper.ProveedorProductoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.repository.ProveedorProductoRepository;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorProductoDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.port.ProveedorProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProveedorProductoBdAdapter implements ProveedorProductoRepositoryPort {

    private final ProveedorProductoRepository proveedorProductoRepository;
    private final ProveedorProductoMapper proveedorProductoMapper;

    @Override
    public ProveedorProductoDomain guardar(ProveedorProductoDomain proveedorProducto) {
        return proveedorProductoMapper.toDomain(
                proveedorProductoRepository.save(proveedorProductoMapper.toEntity(proveedorProducto))
        );
    }

    @Override
    public List<ProveedorProductoDomain> listar() {
        return proveedorProductoRepository.findAll()
                .stream()
                .map(proveedorProductoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProveedorProductoDomain> obtenerPorId(Integer id) {
        return proveedorProductoRepository.findById(id)
                .map(proveedorProductoMapper::toDomain);
    }

    @Override
    public List<ProveedorProductoDomain> listarPorProveedor(Integer proveedorId) {
        return proveedorProductoRepository.findByProveedor_ProveedorId(proveedorId)
                .stream()
                .map(proveedorProductoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Integer id) {
        proveedorProductoRepository.deleteById(id);
    }
}
