/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cc.Service;

import com.cc.dao.ProductoDao;
import com.cc.domain.Producto;
import com.cc.domain.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cc.dao.ProductoDao;
import com.cc.dao.ProveedorDao;
import com.cc.domain.Proveedor;


// crea la conexion entre la base de datos y la parte grafica

@Service
public class ProductoServiceImpl implements ProductoService {
    
    
    //si el objeto esta en memoria no se crea// pero si no existe lo crea
    @Autowired
    private ProductoDao productoDao;
       
    //@Autowired
    //private ProveedorDao proveedorDao;
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    
    //aqui va la implementacion de credito
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos() {
        return (List<Producto>)productoDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Producto producto) {
        //si el idProducto es 0 lo inserta
        // si tiene valor el idproducto lo agrega
        //se toma el dato de credito dentro de cleitne  
        //Proveedor proveedor = producto.getProveedor();
        //inserta el zona antes que el zona
        //proveedor = proveedorDao.save(proveedor);
        //producto.setProveedor(proveedor);
        productoDao.save(producto);
    }
    
    @Override
    @Transactional
    public void delete (Producto producto) {
        productoDao.delete(producto);
    }

    

}
