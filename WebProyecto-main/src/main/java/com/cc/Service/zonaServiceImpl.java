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
import com.cc.dao.ZonaDao;


// crea la conexion entre la base de datos y la parte grafica

@Service
public class zonaServiceImpl implements ZonaService {
    
    
    //si el objeto esta en memoria no se crea// pero si no existe lo crea
    @Autowired
    private ZonaDao zonaDao;
    
    //aqui va la implementacion de vehiculo
    @Autowired
    private VehiculoDao vehiculoDao;
    
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    
    //aqui va la implementacion de vehiculo
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Zona> getZonas() {
        return (List<Zona>)zonaDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Zona getZona(Zona zona) {
        return zonaDao.findById(zona.getIdZona()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Zona zona) {
        //si el idZona es 0 lo inserta
        // si tiene valor el idzona lo agrega
        //se toma el dato de vehiculo dentro de cleitne
        Vehiculo vehiculo = zona.getVehiculo();
        //inserta el vehiculo antes que el zona
        vehiculo = vehiculoDao.save(vehiculo);
        zona.setVehiculo(vehiculo);
        zonaDao.save(zona);
    }
    
    @Override
    @Transactional
    public void delete (Zona zona) {
        zonaDao.delete(zona);
    }

    

}
