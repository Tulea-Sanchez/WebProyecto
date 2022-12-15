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
public class EstadisticaProveedor implements Serializable {
 

    private int id;
    private String descripcion;
    private int cantidadProductos;

    public EstadisticaProveedor(int id, String descripcion, int cantidadProductos) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidadProductos = cantidadProductos;
    }


    public EstadisticaProveedor() {
    }

    
    
}
