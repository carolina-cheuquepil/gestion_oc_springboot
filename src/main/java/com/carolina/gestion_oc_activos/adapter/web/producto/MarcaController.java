package com.carolina.gestion_oc_activos.adapter.web.producto;

import com.carolina.gestion_oc_activos.application.service.MarcaService;
import com.carolina.gestion_oc_activos.domain.producto.model.MarcaDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos/marcas")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<MarcaDomain>> listar() {
        return ResponseEntity.ok(marcaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDomain> obtenerPorId(@PathVariable Integer id) {
        return marcaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
