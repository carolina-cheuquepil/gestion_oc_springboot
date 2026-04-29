package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.ConceptoGastoService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.ConceptoGastoDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo/conceptos-gasto")
@CrossOrigin(origins = "http://localhost:4200")
public class ConceptoGastoController {

    private final ConceptoGastoService conceptoGastoService;

    public ConceptoGastoController(ConceptoGastoService conceptoGastoService) {
        this.conceptoGastoService = conceptoGastoService;
    }

    @GetMapping
    public ResponseEntity<List<ConceptoGastoDomain>> listar() {
        return ResponseEntity.ok(conceptoGastoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConceptoGastoDomain> obtenerPorId(@PathVariable Integer id) {
        return conceptoGastoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
