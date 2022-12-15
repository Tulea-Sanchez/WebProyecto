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
public class Estadistica implements Serializable {
 
    
    private String zona;
    private int saldo;
    private int cuentas;
    private String vehiculo;

    public Estadistica(String zona, String vehiculo, int cuentas, int saldo) {
        this.zona = zona;
        this.saldo = saldo;
        this.cuentas = cuentas;
        this.vehiculo = vehiculo;
    }
            
    

    

    public Estadistica() {
    }

    
    
}
