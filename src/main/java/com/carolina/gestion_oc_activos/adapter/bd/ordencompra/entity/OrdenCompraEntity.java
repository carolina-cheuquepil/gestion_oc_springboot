package com.carolina.gestion_oc_activos.adapter.bd.ordencompra.entity;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.*;
import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.EmpresaEntity;
import com.carolina.gestion_oc_activos.adapter.bd.empresa.entity.UsuarioEntity;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorContactoEntity;
import com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity.ProveedorEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orden_compra")
@Data
public class OrdenCompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oc_id")
    private Integer ocId;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaEntity empresa;

    @ManyToOne
    @JoinColumn(name = "tipo_oc_id", nullable = false)
    private TipoOCEntity tipoOc;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @ManyToOne
    @JoinColumn(name = "usuario_solicitante_id", nullable = false)
    private UsuarioEntity usuarioSolicitante;

    @ManyToOne
    @JoinColumn(name = "usuario_aprobador_id")
    private UsuarioEntity usuarioAprobador;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "proveedor_contacto_id")
    private ProveedorContactoEntity proveedorContacto;

    @ManyToOne
    @JoinColumn(name = "condicion_compra_id", nullable = false)
    private CondicionCompraEntity condicionCompra;

    @ManyToOne
    @JoinColumn(name = "moneda_id", nullable = false)
    private MonedaEntity moneda;

    @ManyToOne
    @JoinColumn(name = "centro_gestion_id", nullable = false)
    private CentroGestionEntity centroGestion;

    @ManyToOne
    @JoinColumn(name = "estado_oc_id", nullable = false)
    private EstadoOcEntity estado;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaContableEntity cuentaContable;

    @ManyToOne
    @JoinColumn(name = "concepto_gasto_id")
    private ConceptoGastoEntity conceptoGasto;

    @OneToMany(mappedBy = "ordenCompra")
    @Fetch(FetchMode.SUBSELECT)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<OrdenCompraItemEntity> items = new ArrayList<>();

    // Campos simples
    @Column(name = "observacion", length = 500)
    private String observacion;

    @Column(name = "subtotal")
    private BigDecimal subtotal = BigDecimal.ZERO;

    @Column(name = "descuento_total")
    private BigDecimal descuentoTotal = BigDecimal.ZERO;

    @Column(name = "impuesto_total")
    private BigDecimal impuestoTotal = BigDecimal.ZERO;

    @Column(name = "total")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Auditoría automática
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
