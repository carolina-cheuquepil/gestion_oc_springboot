package com.carolina.gestion_oc_activos.adapter.web.producto;

import com.carolina.gestion_oc_activos.application.service.UomService;
import com.carolina.gestion_oc_activos.domain.producto.model.UomDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos/uom")
@CrossOrigin(origins = "http://localhost:4200")
public class UomController {

    private final UomService uomService;

    public UomController(UomService uomService) {
        this.uomService = uomService;
    }

    @GetMapping
    public ResponseEntity<List<UomDomain>> listar() {
        return ResponseEntity.ok(uomService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UomDomain> obtenerPorId(@PathVariable Integer id) {
        return uomService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
