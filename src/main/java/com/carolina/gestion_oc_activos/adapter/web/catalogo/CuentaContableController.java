package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.CuentaContableService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.CuentaContableDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo/cuentas-contables")
@CrossOrigin(origins = "http://localhost:4200")
public class CuentaContableController {

    private final CuentaContableService cuentaContableService;

    public CuentaContableController(CuentaContableService cuentaContableService) {
        this.cuentaContableService = cuentaContableService;
    }

    @GetMapping
    public ResponseEntity<List<CuentaContableDomain>> listar() {
        return ResponseEntity.ok(cuentaContableService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaContableDomain> obtenerPorId(@PathVariable Integer id) {
        return cuentaContableService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
