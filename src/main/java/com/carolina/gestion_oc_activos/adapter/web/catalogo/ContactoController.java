package com.carolina.gestion_oc_activos.adapter.web.catalogo;

import com.carolina.gestion_oc_activos.application.service.ContactoService;
import com.carolina.gestion_oc_activos.domain.catalogo.model.ContactoDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactos")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ContactoController {

    private final ContactoService contactoService;

    @PostMapping
    public ResponseEntity<ContactoDomain> crear(@RequestBody ContactoDomain contacto) {
        return ResponseEntity.ok(contactoService.guardar(contacto));
    }

    @GetMapping
    public ResponseEntity<List<ContactoDomain>> listar() {
        return ResponseEntity.ok(contactoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoDomain> obtenerPorId(@PathVariable Integer id) {
        return contactoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactoDomain> actualizar(@PathVariable Integer id,
                                                     @RequestBody ContactoDomain contacto) {
        contacto.setContactoId(id);
        return ResponseEntity.ok(contactoService.guardar(contacto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        contactoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
