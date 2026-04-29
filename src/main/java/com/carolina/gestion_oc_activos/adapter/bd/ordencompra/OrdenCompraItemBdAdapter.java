package com.carolina.gestion_oc_activos.adapter.bd.ordencompra;

import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.entity.OrdenCompraEntity;
import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.mapper.OrdenCompraItemMapper;
import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.repository.OrdenCompraItemRepository;
import com.carolina.gestion_oc_activos.adapter.bd.ordencompra.repository.OrdenCompraRepository;
import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraItemDomain;
import com.carolina.gestion_oc_activos.domain.ordencompra.port.OrdenCompraItemRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrdenCompraItemBdAdapter implements OrdenCompraItemRepositoryPort {

    private final OrdenCompraItemRepository itemRepository;
    private final OrdenCompraRepository ordenCompraRepository;
    private final OrdenCompraItemMapper itemMapper;

    @Override
    public OrdenCompraItemDomain guardar(OrdenCompraItemDomain item) {
        var entity = itemMapper.toEntity(item);
        OrdenCompraEntity oc = ordenCompraRepository.findById(item.getOcId())
                .orElseThrow(() -> new IllegalArgumentException("Orden de compra no encontrada con id: " + item.getOcId()));
        entity.setOrdenCompra(oc);
        return itemMapper.toDomain(itemRepository.save(entity));
    }

    @Override
    public List<OrdenCompraItemDomain> listarPorOc(Integer ocId) {
        return itemRepository.findByOrdenCompraOcId(ocId)
                .stream()
                .map(itemMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrdenCompraItemDomain> obtenerPorId(Integer id) {
        return itemRepository.findById(id).map(itemMapper::toDomain);
    }

    @Override
    public void eliminar(Integer id) {
        itemRepository.deleteById(id);
    }
}
