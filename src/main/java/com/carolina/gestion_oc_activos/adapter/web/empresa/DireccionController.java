package com.carolina.gestion_oc_activos.adapter.web.empresa;

import com.carolina.gestion_oc_activos.application.service.DireccionService;
import com.carolina.gestion_oc_activos.domain.empresa.model.DireccionDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
@CrossOrigin(origins = "http://localhost:4200")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping
    public ResponseEntity<DireccionDomain> crear(@RequestBody DireccionDomain direccion) {
        return ResponseEntity.ok(direccionService.guardar(direccion));
    }

    @GetMapping
    public ResponseEntity<List<DireccionDomain>> listar() {
        return ResponseEntity.ok(direccionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionDomain> obtenerPorId(@PathVariable Integer id) {
        return direccionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionDomain> actualizar(@PathVariable Integer id,
                                                      @RequestBody DireccionDomain direccion) {
        direccion.setDireccionId(id);
        return ResponseEntity.ok(direccionService.guardar(direccion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        direccionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
