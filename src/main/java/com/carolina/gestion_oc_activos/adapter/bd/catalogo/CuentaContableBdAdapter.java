package com.carolina.gestion_oc_activos.adapter.bd.catalogo;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.mapper.CatalogoMapper;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.repository.CuentaContableRepository;
import com.carolina.gestion_oc_activos.domain.catalogo.model.CuentaContableDomain;
import com.carolina.gestion_oc_activos.domain.catalogo.port.CuentaContableRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CuentaContableBdAdapter implements CuentaContableRepositoryPort {

    private final CuentaContableRepository cuentaContableRepository;
    private final CatalogoMapper catalogoMapper;

    @Override
    public List<CuentaContableDomain> listar() {
        return cuentaContableRepository.findAll()
                .stream()
                .map(catalogoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CuentaContableDomain> obtenerPorId(Integer id) {
        return cuentaContableRepository.findById(id)
                .map(catalogoMapper::toDomain);
    }
}
