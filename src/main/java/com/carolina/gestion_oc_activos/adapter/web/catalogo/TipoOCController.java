package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.TipoOCService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.TipoOCDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo/tipos-oc")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoOCController {

    private final TipoOCService tipoOCService;

    public TipoOCController(TipoOCService tipoOCService) {
        this.tipoOCService = tipoOCService;
    }

    @GetMapping
    public ResponseEntity<List<TipoOCDomain>> listar() {
        return ResponseEntity.ok(tipoOCService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoOCDomain> obtenerPorId(@PathVariable Integer id) {
        return tipoOCService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
