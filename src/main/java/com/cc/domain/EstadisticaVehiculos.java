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
public class EstadisticaVehiculos implements Serializable {
 
    
    private String descripcion;
    private String placa;
    private int zonas;
    private int cuentas;
    private int saldo;

    public EstadisticaVehiculos(String descripcion, String placa, int zonas, int saldo, int cuentas) {
        this.descripcion = descripcion;
        this.placa = placa;
        this.zonas = zonas;
        this.cuentas = cuentas;
        this.saldo = saldo;
    }

    

    public EstadisticaVehiculos() {
    }

    
    
}
