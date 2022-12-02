/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.Service;

import com.cc.domain.Producto;
import java.util.List;

/**
 *
 * @author Tuleaa
 */
public interface ProductoService {
    
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    public List<Producto> getProductos();
    
    public Producto getProducto(Producto producto);
    
    public void save (Producto producto);
    
    public void delete (Producto producto);
}
