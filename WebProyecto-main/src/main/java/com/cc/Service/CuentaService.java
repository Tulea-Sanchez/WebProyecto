/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.Service;

import com.cc.domain.Cuenta;
import java.util.List;

/**
 *
 * @author Tuleaa
 */
public interface CuentaService {
    
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    public List<Cuenta> getCuentas();
    
    public Cuenta getCuenta(Cuenta cuenta);
    
    public Cuenta getCuenta(Long id);
    
    public Cuenta returnNull();
    
    public void save (Cuenta cuenta);
    
    public void delete (Cuenta cuenta);
}
