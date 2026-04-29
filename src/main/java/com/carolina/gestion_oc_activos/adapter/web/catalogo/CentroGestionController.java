package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.CentroGestionService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.CentroGestionDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo/centros-gestion")
@CrossOrigin(origins = "http://localhost:4200")
public class CentroGestionController {

    private final CentroGestionService centroGestionService;

    public CentroGestionController(CentroGestionService centroGestionService) {
        this.centroGestionService = centroGestionService;
    }

    @GetMapping
    public ResponseEntity<List<CentroGestionDomain>> listar() {
        return ResponseEntity.ok(centroGestionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroGestionDomain> obtenerPorId(@PathVariable Integer id) {
        return centroGestionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
