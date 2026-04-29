package com.carolina.gestion_oc_activos.adapter.bd.empresa.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empresa")
@Data
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Integer empresaId;

    @Column(name = "codigo_empresa")
    private Integer codigoEmpresa;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "rut_numero")
    private Integer rutNumero;

    @Column(name = "rut_dv")
    private String rutDv;

    @Column(name = "empresa_estado")
    private Boolean activa;
}
