package com.carolina.gestion_oc_activos.adapter.bd.ordencompra;

import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.mapper.OrdenCompraMapper;
import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.repository.OrdenCompraRepository;
import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraDomain;
import com.carolina.gestion_oc_activos.domain.ordencompra.port.OrdenCompraRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrdenCompraBdAdapter implements OrdenCompraRepositoryPort {

    private final OrdenCompraRepository ordenCompraRepository;
    private final OrdenCompraMapper ordenCompraMapper;

    @Override
    @Transactional
    public OrdenCompraDomain guardar(OrdenCompraDomain ordenCompra) {
        return ordenCompraMapper.toDomain(
                ordenCompraRepository.save(
                        ordenCompraMapper.toEntity(ordenCompra)
                )
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrdenCompraDomain> listar() {
        return ordenCompraRepository.findAll()
                .stream()
                .map(ordenCompraMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrdenCompraDomain> obtenerPorId(Integer id) {
        return ordenCompraRepository.findById(id)
                .map(ordenCompraMapper::toDomain);
    }

    @Override
    public void eliminar(Integer id) {
        ordenCompraRepository.deleteById(id);
    }
}
