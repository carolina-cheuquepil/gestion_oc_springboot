package com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.ContactoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "proveedor_contacto",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_proveedor_contacto", columnNames = {"proveedor_id", "contacto_id"})
        }
)
@Data
public class ProveedorContactoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_contacto_id")
    private Integer proveedorContactoId;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "contacto_id", nullable = false)
    private ContactoEntity contacto;

    @Column(name = "es_principal")
    private Boolean esPrincipal = false;

    @Column(name = "activo")
    private Boolean activo = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
