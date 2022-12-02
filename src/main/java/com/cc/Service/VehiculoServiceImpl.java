/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cc.Service;

import com.cc.dao.VehiculoDao;
import com.cc.domain.Vehiculo;
import com.cc.domain.Zona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cc.dao.ProductoDao;
import com.cc.dao.ZonaDao;


// crea la conexion entre la base de datos y la parte grafica

@Service
public class VehiculoServiceImpl implements VehiculoService {
    
    
    //si el objeto esta en memoria no se crea// pero si no existe lo crea
    @Autowired
    private VehiculoDao vehiculoDao;
       
    @Autowired
    private ZonaDao zonaDao;
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    
    //aqui va la implementacion de credito
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> getVehiculos() {
        return (List<Vehiculo>)vehiculoDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Vehiculo getVehiculo(Vehiculo vehiculo) {
        return vehiculoDao.findById(vehiculo.getIdVehiculo()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Vehiculo vehiculo) {
        //si el idVehiculo es 0 lo inserta
        // si tiene valor el idvehiculo lo agrega
        //se toma el dato de credito dentro de cleitne
        //Zona zona = vehiculo.getZona();
        //inserta el zona antes que el zona
        //zona = zonaDao.save(zona);
        //vehiculo.setZona(zona);
        
        vehiculoDao.save(vehiculo);
    }
    
    @Override
    @Transactional
    public void delete (Vehiculo vehiculo) {
        vehiculoDao.delete(vehiculo);
    }

    

}
