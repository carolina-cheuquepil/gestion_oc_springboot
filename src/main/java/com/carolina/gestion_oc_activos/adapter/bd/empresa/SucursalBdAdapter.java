package com.carolina.gestion_oc_activos.adapter.bd.empresa;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper.SucursalMapper;
import com.carolina.gestion_oc_activos.adapter.bd.empresa.repository.SucursalRepository;
import com.carolina.gestion_oc_activos.domain.empresa.model.SucursalDomain;
import com.carolina.gestion_oc_activos.domain.empresa.port.SucursalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SucursalBdAdapter implements SucursalRepositoryPort {

    private final SucursalRepository sucursalRepository;
    private final SucursalMapper sucursalMapper;

    @Override
    public SucursalDomain guardar(SucursalDomain sucursal) {
        return sucursalMapper.toDomain(
                sucursalRepository.save(
                        sucursalMapper.toEntity(sucursal)
                )
        );
    }

    @Override
    public List<SucursalDomain> listar() {
        return sucursalRepository.findAll()
                .stream()
                .map(sucursalMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SucursalDomain> obtenerPorId(Integer id) {
        return sucursalRepository.findById(id)
                .map(sucursalMapper::toDomain);
    }

    @Override
    public List<SucursalDomain> listarPorEmpresa(Integer empresaId) {
        return sucursalRepository.findByEmpresaEmpresaId(empresaId)
                .stream()
                .map(sucursalMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminar(Integer id) {
        sucursalRepository.deleteById(id);
    }
}
