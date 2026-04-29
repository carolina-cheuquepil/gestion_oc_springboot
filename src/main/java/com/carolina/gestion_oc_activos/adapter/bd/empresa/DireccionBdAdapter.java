package com.carolina.gestion_oc_activos.adapter.bd.empresa;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper.DireccionMapper;
import com.carolina.gestion_oc_activos.adapter.bd.empresa.repository.DireccionRepository;
import com.carolina.gestion_oc_activos.domain.empresa.model.DireccionDomain;
import com.carolina.gestion_oc_activos.domain.empresa.port.DireccionRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DireccionBdAdapter implements DireccionRepositoryPort {

    private final DireccionRepository direccionRepository;
    private final DireccionMapper direccionMapper;

    @Override
    public DireccionDomain guardar(DireccionDomain direccion) {
        return direccionMapper.toDomain(
                direccionRepository.save(
                        direccionMapper.toEntity(direccion)
                )
        );
    }

    @Override
    public List<DireccionDomain> listar() {
        return direccionRepository.findAll()
                .stream()
                .map(direccionMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DireccionDomain> obtenerPorId(Integer id) {
        return direccionRepository.findById(id)
                .map(direccionMapper::toDomain);
    }

    @Override
    public void eliminar(Integer id) {
        direccionRepository.deleteById(id);
    }
}
