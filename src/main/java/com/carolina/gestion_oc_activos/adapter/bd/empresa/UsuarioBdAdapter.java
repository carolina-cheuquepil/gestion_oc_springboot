package com.carolina.gestion_oc_activos.adapter.bd.empresa;

import com.carolina.gestion_oc_activos.adapter.bd.empresa.mapper.UsuarioMapper;
import com.carolina.gestion_oc_activos.adapter.bd.empresa.repository.UsuarioRepository;
import com.carolina.gestion_oc_activos.domain.empresa.model.UsuarioDomain;
import com.carolina.gestion_oc_activos.domain.empresa.port.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioBdAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDomain> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDomain> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDomain);
    }
}
