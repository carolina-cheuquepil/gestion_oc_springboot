package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.ProyectoService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.ProyectoDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogo/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping
    public ResponseEntity<List<ProyectoDomain>> listar() {
        return ResponseEntity.ok(proyectoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDomain> obtenerPorId(@PathVariable Integer id) {
        return proyectoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
