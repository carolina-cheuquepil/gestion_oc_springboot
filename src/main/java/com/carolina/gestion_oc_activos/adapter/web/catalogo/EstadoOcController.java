package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.EstadoOcService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.EstadoOcDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo/estados-oc")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoOcController {

    private final EstadoOcService estadoOcService;

    public EstadoOcController(EstadoOcService estadoOcService) {
        this.estadoOcService = estadoOcService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoOcDomain>> listar() {
        return ResponseEntity.ok(estadoOcService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoOcDomain> obtenerPorId(@PathVariable Integer id) {
        return estadoOcService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
