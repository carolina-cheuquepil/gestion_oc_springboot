package com.carolina.gestion_oc_activos.adapter.bd.producto.entity;

import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.ConceptoGastoEntity;
import com.carolina.gestion_oc_activos.adapter.bd.catalogo.entity.CuentaContableEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "producto_nombre", nullable = false, length = 100)
    private String productoNombre;

    @Column(name = "descripcion", columnDefinition = "LONGTEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaEntity marca;

    @Column(name = "sku", nullable = false, length = 50)
    private String sku;

    @ManyToOne
    @JoinColumn(name = "tipo_producto_id", nullable = false)
    private TipoProductoEntity tipoProducto;

    @ManyToOne
    @JoinColumn(name = "uom_id")
    private UomEntity uom;

    @ManyToOne
    @JoinColumn(name = "cuenta_contable_id")
    private CuentaContableEntity cuentaContable;

    @ManyToOne
    @JoinColumn(name = "concepto_gasto_id")
    private ConceptoGastoEntity conceptoGasto;
}
