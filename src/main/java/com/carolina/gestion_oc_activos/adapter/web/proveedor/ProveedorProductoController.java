package com.carolina.gestion_oc_activos.adapter.web.proveedor;

import com.carolina.gestion_oc_activos.application.service.ProveedorProductoService;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorDomain;
import com.carolina.gestion_oc_activos.domain.proveedor.model.ProveedorProductoDomain;
import com.carolina.gestion_oc_activos.domain.producto.model.ProductoDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorProductoController {

    private final ProveedorProductoService proveedorProductoService;

    public ProveedorProductoController(ProveedorProductoService proveedorProductoService) {
        this.proveedorProductoService = proveedorProductoService;
    }

    @PostMapping("/{proveedorId}/productos")
    public ResponseEntity<ProveedorProductoDomain> crear(@PathVariable Integer proveedorId,
                                                         @RequestBody ProveedorProductoDomain proveedorProducto) {
        if (proveedorProducto.getProveedor() == null) {
            proveedorProducto.setProveedor(new ProveedorDomain());
        }
        proveedorProducto.getProveedor().setProveedorId(proveedorId);
        return ResponseEntity.ok(proveedorProductoService.guardar(proveedorProducto));
    }

    @GetMapping("/productos")
    public ResponseEntity<List<ProveedorProductoDomain>> listar() {
        return ResponseEntity.ok(proveedorProductoService.listar());
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProveedorProductoDomain> obtenerPorId(@PathVariable Integer id) {
        return proveedorProductoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{proveedorId}/productos")
    public ResponseEntity<List<ProveedorProductoDomain>> listarPorProveedor(@PathVariable Integer proveedorId) {
        return ResponseEntity.ok(proveedorProductoService.listarPorProveedor(proveedorId));
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        proveedorProductoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
