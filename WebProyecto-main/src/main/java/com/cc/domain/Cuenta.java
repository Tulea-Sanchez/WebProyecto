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
@Table( name= "cuentas")
public class Cuenta implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    
    @JoinColumn(name="id_cliente")
    @ManyToOne
    private Cliente cliente;
    private String ult_abono;
    private int saldo;

    public Cuenta(Long idCuenta, Cliente cliente, String ult_abono, int saldo) {
        this.idCuenta = idCuenta;
        this.cliente = cliente;
        this.ult_abono = ult_abono;
        this.saldo = saldo;
    }

    

    public Cuenta() {
    }

    
    
}
