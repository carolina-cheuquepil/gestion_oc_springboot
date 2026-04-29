package com.carolina.gestion_oc_activos.adapter.web.empresa;

import com.carolina.gestion_oc_activos.application.service.EmpresaService;
import com.carolina.gestion_oc_activos.domain.empresa.model.EmpresaDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<EmpresaDomain> crear(@RequestBody EmpresaDomain empresa) {
        return ResponseEntity.ok(empresaService.guardar(empresa));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaDomain>> listar() {
        return ResponseEntity.ok(empresaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDomain> obtenerPorId(@PathVariable Integer id) {
        return empresaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDomain> actualizar(@PathVariable Integer id,
                                                    @RequestBody EmpresaDomain empresa) {
        empresa.setEmpresaId(id);
        return ResponseEntity.ok(empresaService.guardar(empresa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        empresaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
