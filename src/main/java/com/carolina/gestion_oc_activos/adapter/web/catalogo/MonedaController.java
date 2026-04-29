package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.MonedaService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.MonedaDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo/monedas")
@CrossOrigin(origins = "http://localhost:4200")
public class MonedaController {

    private final MonedaService monedaService;

    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    @GetMapping
    public ResponseEntity<List<MonedaDomain>> listar() {
        return ResponseEntity.ok(monedaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonedaDomain> obtenerPorId(@PathVariable Integer id) {
        return monedaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
