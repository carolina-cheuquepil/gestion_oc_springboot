package com.carolina.gestion_oc_activos.adapter.web.ordencompra;

import com.carolina.gestion_oc_activos.application.service.OrdenCompraService;
import com.carolina.gestion_oc_activos.domain.ordencompra.model.OrdenCompraDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-compra")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @PostMapping
    public ResponseEntity<OrdenCompraDomain> crear(@RequestBody OrdenCompraDomain ordenCompra) {
        return ResponseEntity.ok(ordenCompraService.guardar(ordenCompra));
    }

    @GetMapping
    public ResponseEntity<List<OrdenCompraDomain>> listar() {
        return ResponseEntity.ok(ordenCompraService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompraDomain> obtenerPorId(@PathVariable Integer id) {
        return ordenCompraService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenCompraDomain> actualizar(@PathVariable Integer id,
                                                        @RequestBody OrdenCompraDomain ordenCompra) {
        ordenCompra.setOcId(id);
        return ResponseEntity.ok(ordenCompraService.guardar(ordenCompra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        ordenCompraService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
