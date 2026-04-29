package com.carolina.gestion_oc_activos.adapter.web.producto;

import com.carolina.gestion_oc_activos.application.service.TipoProductoService;
import com.carolina.gestion_oc_activos.domain.producto.model.TipoProductoDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos/tipos")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoProductoController {

    private final TipoProductoService tipoProductoService;

    public TipoProductoController(TipoProductoService tipoProductoService) {
        this.tipoProductoService = tipoProductoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoProductoDomain>> listar() {
        return ResponseEntity.ok(tipoProductoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProductoDomain> obtenerPorId(@PathVariable Integer id) {
        return tipoProductoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
