package com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tipo_oc")
@Data
public class TipoOCEntity {

    @Id
    @Column(name = "tipo_oc_id")
    private Integer tipoOcId;

    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;

    @Column(name = "afecta_iva", nullable = false)
    private Boolean afectaIva;

    @Column(name = "requiere_retencion", nullable = false)
    private Boolean requiereRetencion;
}
