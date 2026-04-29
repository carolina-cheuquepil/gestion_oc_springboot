package com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "contacto",
        indexes = {
                @Index(name = "persona_apellid_d63688_idx", columnList = "apellidos,nombres")
        }
)
@Data
public class ContactoEntity {

    @Id
    @Column(name = "contacto_id", nullable = false)
    private Integer contactoId;

    @Column(name = "nombres", nullable = false, length = 80)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "email", length = 120)
    private String email;

    @Column(name = "celular", length = 20)
    private String celular;
}
