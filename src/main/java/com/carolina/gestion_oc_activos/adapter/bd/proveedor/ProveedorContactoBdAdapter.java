package com.carolina.gestion_oc_activos.adapter.bd.proveedor;

import com.carolina.gestion_oc_activos.adapter.bd.proveedor.mapper.ProveedorContactoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.repository.ProveedorContactoRepository;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorContactoDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.port.ProveedorContactoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProveedorContactoBdAdapter implements ProveedorContactoRepositoryPort {

    private final ProveedorContactoRepository proveedorContactoRepository;
    private final ProveedorContactoMapper proveedorContactoMapper;

    @Override
    public ProveedorContactoDomain guardar(ProveedorContactoDomain proveedorContacto) {
        return proveedorContactoMapper.toDomain(
                proveedorContactoRepository.save(proveedorContactoMapper.toEntity(proveedorContacto))
        );
    }

    @Override
    public List<ProveedorContactoDomain> listar() {
        return proveedorContactoRepository.findAll()
                .stream()
                .map(proveedorContactoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProveedorContactoDomain> obtenerPorId(Integer id) {
        return proveedorContactoRepository.findById(id)
                .map(proveedorContactoMapper::toDomain);
    }

    @Override
    public List<ProveedorContactoDomain> listarPorProveedor(Integer proveedorId) {
        return proveedorContactoRepository.findByProveedor_ProveedorId(proveedorId)
                .stream()
                .map(proveedorContactoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Integer id) {
        proveedorContactoRepository.deleteById(id);
    }
}
