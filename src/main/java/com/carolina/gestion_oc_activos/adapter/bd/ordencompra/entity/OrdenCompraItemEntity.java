package com.carolina.gestion_oc_activos.adapter.bd.ordencompra.entity;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.ConceptoGastoEntity;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.CuentaContableEntity;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.ProyectoEntity;
import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.ProductoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orden_compra_item")
@Data
public class OrdenCompraItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oc_item_id")
    private Integer ocItemId;

    @ManyToOne
    @JoinColumn(name = "oc_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private OrdenCompraEntity ordenCompra;

    @Column(name = "nro_linea", nullable = false)
    private Integer nroLinea;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;

    @Column(name = "descripcion_libre", length = 255)
    private String descripcion;

    @Column(name = "cantidad", nullable = false, precision = 14, scale = 3)
    private BigDecimal cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 14, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "descuento_porcentaje", nullable = false, precision = 5, scale = 2)
    private BigDecimal descuentoPorcentaje;

    @Column(name = "afecta_iva", nullable = false)
    private Boolean afectaIva;

    @Column(name = "iva_porcentaje", nullable = false, precision = 5, scale = 2)
    private BigDecimal ivaPorcentaje;

    @Column(name = "subtotal_neto", nullable = false, precision = 14, scale = 2)
    private BigDecimal subtotalNeto;

    @Column(name = "subtotal_iva", nullable = false, precision = 14, scale = 2)
    private BigDecimal subtotalIva;

    @Column(name = "subtotal_total", nullable = false, precision = 14, scale = 2)
    private BigDecimal subtotalTotal;

    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private ProyectoEntity proyecto;

    @ManyToOne
    @JoinColumn(name = "cuenta_contable_id")
    private CuentaContableEntity cuentaContable;

    @ManyToOne
    @JoinColumn(name = "concepto_gasto_id")
    private ConceptoGastoEntity conceptoGasto;

    @Column(name = "observacion", length = 255)
    private String observacion;

    @Column(name = "creado_en", updatable = false)
    private LocalDateTime creadoEn;

    @Column(name = "actualizado_en")
    private LocalDateTime actualizadoEn;

    @PrePersist
    public void prePersist() {
        this.creadoEn = LocalDateTime.now();
        this.actualizadoEn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.actualizadoEn = LocalDateTime.now();
    }
}
