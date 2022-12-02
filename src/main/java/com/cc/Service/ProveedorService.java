/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.Service;

import com.cc.domain.Proveedor;
import java.util.List;

/**
 *
 * @author Tuleaa
 */
public interface ProveedorService {
    
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    public List<Proveedor> getProveedors();
    
    public Proveedor getProveedor(Proveedor proveedor);
    
    public void save (Proveedor proveedor);
    
    public void delete (Proveedor proveedor);
}
