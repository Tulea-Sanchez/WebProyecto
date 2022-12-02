/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author Tuleaa
 */
@Data
@Entity
@Table(name="productos")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    
    @JoinColumn(name="id_proveedor", referencedColumnName="id_proveedor")
    @ManyToOne
    private Proveedor proveedor;
    
    private String descripcion;
    private int cantidad,precio_unit;

    public Producto(Proveedor proveedor, String descripcion, int cantidad, int precio_unit) {
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_unit = precio_unit;
    }

    


    public Producto() {
    }
    
    

    

    
    
    
}
