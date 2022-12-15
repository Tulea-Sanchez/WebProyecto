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
@Table(name="proveedores")
public class Proveedor implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proveedor")
    private Long idProveedor;
    
    
    private String descripcion,telefono,num_cuenta;

    public Proveedor(String descripcion, String telefono, String num_cuenta) {
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.num_cuenta = num_cuenta;
    }

    public Proveedor() {
    }



    
    
    
}
