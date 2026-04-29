package com.carolina.gestion_oc_activos.adapter.web.ordencompra;

import com.carolina.gestion_oc_activos.application.service.OrdenCompraItemService;
import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraItemDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-compra/{ocId}/items")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenCompraItemController {

    private final OrdenCompraItemService itemService;

    public OrdenCompraItemController(OrdenCompraItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<OrdenCompraItemDomain> crear(@PathVariable Integer ocId,
                                                       @RequestBody OrdenCompraItemDomain item) {
        return ResponseEntity.ok(itemService.guardar(ocId, item));
    }

    @GetMapping
    public ResponseEntity<List<OrdenCompraItemDomain>> listar(@PathVariable Integer ocId) {
        return ResponseEntity.ok(itemService.listarPorOc(ocId));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<OrdenCompraItemDomain> obtenerPorId(@PathVariable Integer ocId,
                                                              @PathVariable Integer itemId) {
        return itemService.obtenerPorId(itemId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<OrdenCompraItemDomain> actualizar(@PathVariable Integer ocId,
                                                            @PathVariable Integer itemId,
                                                            @RequestBody OrdenCompraItemDomain item) {
        item.setOcItemId(itemId);
        return ResponseEntity.ok(itemService.guardar(ocId, item));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer ocId,
                                         @PathVariable Integer itemId) {
        itemService.eliminar(itemId);
        return ResponseEntity.noContent().build();
    }
}
