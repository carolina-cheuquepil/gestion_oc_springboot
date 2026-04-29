package com.carolina.gestion_oc_activos.adapter.bd.proveedor;

import com.carolina.gestion_oc_activos.adapter.bd.proveedor.mapper.ProveedorMapper;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.repository.ProveedorRepository;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.port.ProveedorRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProveedorBdAdapter implements ProveedorRepositoryPort {

    private final ProveedorRepository proveedorRepository;
    private final ProveedorMapper proveedorMapper;

    public ProveedorBdAdapter(ProveedorRepository proveedorRepository, ProveedorMapper proveedorMapper) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorMapper = proveedorMapper;
    }
    @Override
    public ProveedorDomain guardar(ProveedorDomain proveedor) {
        return proveedorMapper.toDomain(
                proveedorRepository.save(
                        proveedorMapper.toEntity(proveedor)
                )
        );
    }

    @Override
    public List<ProveedorDomain> listar() {
        return proveedorRepository.findAll()
                .stream()
                .map(proveedorMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProveedorDomain> obtenerPorId(Integer id) {
        return proveedorRepository.findById(id)
                .map(proveedorMapper::toDomain);
    }

    @Override
    public void eliminar(Integer id) {
        proveedorRepository.deleteById(id);
    }


}
