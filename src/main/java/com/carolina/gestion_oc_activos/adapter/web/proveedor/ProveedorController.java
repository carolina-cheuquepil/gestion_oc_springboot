package com.carolina.gestion_oc_activos.adapter.web.proveedor;

import com.carolina.gestion_oc_activos.application.service.ProveedorService;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping
    public ResponseEntity<ProveedorDomain> crear(@RequestBody ProveedorDomain proveedor) {
        return ResponseEntity.ok(proveedorService.guardar(proveedor));
    }

    @GetMapping
    public ResponseEntity<List<ProveedorDomain>> listar() {
        return ResponseEntity.ok(proveedorService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDomain> obtenerPorId(@PathVariable Integer id) {
        return proveedorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDomain> actualizar(@PathVariable Integer id,
                                                    @RequestBody ProveedorDomain proveedor) {
        proveedor.setProveedorId(id);
        return ResponseEntity.ok(proveedorService.guardar(proveedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        proveedorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}

// 08/04 Parte Fin