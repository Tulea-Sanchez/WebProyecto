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
@Table( name= "Clientes")
public class Cliente implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    
    private String nombre,telefono,direccion,id_zona;

    public Cliente(String nombre, String telefono, String direccion, String id_zona) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_zona = id_zona;
    }
    
    public Cliente(){}
    
}
