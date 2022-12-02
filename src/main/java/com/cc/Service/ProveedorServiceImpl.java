/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cc.Service;

import com.cc.dao.ProveedorDao;
import com.cc.domain.Proveedor;
import com.cc.domain.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cc.dao.ProductoDao;


// crea la conexion entre la base de datos y la parte grafica

@Service
public class ProveedorServiceImpl implements ProveedorService {
    
    
    //si el objeto esta en memoria no se crea// pero si no existe lo crea
    @Autowired
    private ProveedorDao proveedorDao;
       
    
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    
    //aqui va la implementacion de credito
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> getProveedors() {
        return (List<Proveedor>)proveedorDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Proveedor getProveedor(Proveedor proveedor) {
        return proveedorDao.findById(proveedor.getIdProveedor()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Proveedor proveedor) {
        //si el idProveedor es 0 lo inserta
        // si tiene valor el idproveedor lo agrega
        //se toma el dato de credito dentro de cleitne       
        proveedorDao.save(proveedor);
    }
    
    @Override
    @Transactional
    public void delete (Proveedor proveedor) {
        proveedorDao.delete(proveedor);
    }

    

}
