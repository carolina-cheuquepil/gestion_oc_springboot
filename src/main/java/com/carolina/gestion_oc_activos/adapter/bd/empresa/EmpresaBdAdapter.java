package com.carolina.gestion_oc_activos.adapter.bd.empresa;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.repository.EmpresaRepository;
import com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper.EmpresaMapper;
import com.carolina.gestion_oc_activos.domain.empresa.model.EmpresaDomain;
import com.carolina.gestion_oc_activos.domain.empresa.port.EmpresaRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmpresaBdAdapter implements EmpresaRepositoryPort {

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    public EmpresaBdAdapter(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
    }

    @Override
    public EmpresaDomain guardar(EmpresaDomain empresa) {
        return empresaMapper.toDomain(
                empresaRepository.save(
                        empresaMapper.toEntity(empresa)
                )
        );
    }

    @Override
    public List<EmpresaDomain> listar() {
        return empresaRepository.findAll()
                .stream()
                .map(empresaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmpresaDomain> obtenerPorId(Integer id) {
        return empresaRepository.findById(id)
                .map(empresaMapper::toDomain);
    }

    @Override
    public void eliminar(Integer id) {
        empresaRepository.deleteById(id);
    }
}
