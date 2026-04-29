package com.carolina.gestion_oc_activos.adapter.bd.proveedor.entity;

import com.carolina.gestion_oc_activos.adapter.bd.producto.entity.ProductoEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(
        name = "proveedor_producto",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_proveedor_producto", columnNames = {"proveedor_id", "producto_id"})
        }
)
@Data
public class ProveedorProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_producto_id")
    private Integer proveedorProductoId;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private ProveedorEntity proveedor;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoEntity producto;
}
