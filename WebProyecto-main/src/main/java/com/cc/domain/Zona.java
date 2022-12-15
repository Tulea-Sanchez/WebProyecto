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
@Table(name="zonas")
public class Zona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_zona")
    private Long idZona;
    
    @JoinColumn(name="id_vehiculo", referencedColumnName="id_vehiculo")
    @ManyToOne
    private Vehiculo vehiculo;
    
    private String descripcion;

    public Zona(Vehiculo vehiculo, String descripcion) {
        this.vehiculo = vehiculo;
        this.descripcion = descripcion;
    }

    public Zona() {
    }
    
    

    

    
    
    
}
