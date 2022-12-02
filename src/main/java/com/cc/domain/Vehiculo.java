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
@Table(name="vehiculos")
public class Vehiculo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vehiculo")
    private Long idVehiculo;
    
    private String num_placa,descripcion;

    public Vehiculo(String num_placa, String descripcion) {
        this.num_placa = num_placa;
        this.descripcion = descripcion;
    }

    public Vehiculo() {
    }
    
    
    

    

    
    
    
}
