package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.CondicionCompraService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.CondicionCompraDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo/condiciones-compra")
@CrossOrigin(origins = "http://localhost:4200")
public class CondicionCompraController {

    private final CondicionCompraService condicionCompraService;

    public CondicionCompraController(CondicionCompraService condicionCompraService) {
        this.condicionCompraService = condicionCompraService;
    }

    @GetMapping
    public ResponseEntity<List<CondicionCompraDomain>> listar() {
        return ResponseEntity.ok(condicionCompraService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicionCompraDomain> obtenerPorId(@PathVariable Integer id) {
        return condicionCompraService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
