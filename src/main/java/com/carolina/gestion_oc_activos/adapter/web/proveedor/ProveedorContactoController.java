package com.carolina.gestion_oc_activos.adapter.web.proveedor;

import com.carolina.gestion_oc_activos.application.service.ProveedorContactoService;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorContactoDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorContactoController {

    private final ProveedorContactoService proveedorContactoService;

    public ProveedorContactoController(ProveedorContactoService proveedorContactoService) {
        this.proveedorContactoService = proveedorContactoService;
    }

    @PostMapping("/{proveedorId}/contactos")
    public ResponseEntity<ProveedorContactoDomain> crear(@PathVariable Integer proveedorId,
                                                         @RequestBody ProveedorContactoDomain proveedorContacto) {
        proveedorContacto.getProveedor().setProveedorId(proveedorId);
        return ResponseEntity.ok(proveedorContactoService.guardar(proveedorContacto));
    }

    @GetMapping("/contactos")
    public ResponseEntity<List<ProveedorContactoDomain>> listar() {
        return ResponseEntity.ok(proveedorContactoService.listar());
    }

    @GetMapping("/contactos/{id}")
    public ResponseEntity<ProveedorContactoDomain> obtenerPorId(@PathVariable Integer id) {
        return proveedorContactoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{proveedorId}/contactos")
    public ResponseEntity<List<ProveedorContactoDomain>> listarPorProveedor(@PathVariable Integer proveedorId) {
        return ResponseEntity.ok(proveedorContactoService.listarPorProveedor(proveedorId));
    }

    @PutMapping("/contactos/{id}")
    public ResponseEntity<ProveedorContactoDomain> actualizar(@PathVariable Integer id,
                                                              @RequestBody ProveedorContactoDomain proveedorContacto) {
        proveedorContacto.setProveedorContactoId(id);
        return ResponseEntity.ok(proveedorContactoService.guardar(proveedorContacto));
    }

    @DeleteMapping("/contactos/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        proveedorContactoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
