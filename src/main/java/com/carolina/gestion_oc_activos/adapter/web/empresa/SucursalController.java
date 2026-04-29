package com.carolina.gestion_oc_activos.adapter.web.empresa;

import com.carolina.gestion_oc_activos.application.service.SucursalService;
import com.carolina.gestion_oc_activos.domain.empresa.model.SucursalDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
@CrossOrigin(origins = "http://localhost:4200")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping
    public ResponseEntity<SucursalDomain> crear(@RequestBody SucursalDomain sucursal) {
        return ResponseEntity.ok(sucursalService.guardar(sucursal));
    }

    @GetMapping
    public ResponseEntity<List<SucursalDomain>> listar() {
        return ResponseEntity.ok(sucursalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalDomain> obtenerPorId(@PathVariable Integer id) {
        return sucursalService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<SucursalDomain>> listarPorEmpresa(@PathVariable Integer empresaId) {
        return ResponseEntity.ok(sucursalService.listarPorEmpresa(empresaId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDomain> actualizar(@PathVariable Integer id,
                                                     @RequestBody SucursalDomain sucursal) {
        sucursal.setSucursalId(id);
        return ResponseEntity.ok(sucursalService.guardar(sucursal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        sucursalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
