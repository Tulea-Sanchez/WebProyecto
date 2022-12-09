/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cc.Service;


import com.cc.dao.ClienteDao;
import com.cc.dao.CuentasDao;

import com.cc.domain.Cuenta;
import com.cc.domain.Zona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cc.dao.ProductoDao;
import com.cc.dao.ZonaDao;
import com.cc.domain.Cliente;


// crea la conexion entre la base de datos y la parte grafica

@Service
public class CuentaServiceImpl implements CuentaService {
    
    
    //si el objeto esta en memoria no se crea// pero si no existe lo crea
    @Autowired
    private CuentasDao cuentaDao;
       
    @Autowired
    private ClienteDao clienteDao;
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    @Autowired
    private ZonaDao zonaDao;
    //aqui va la implementacion de credito
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Cuenta> getCuentas() {
        return (List<Cuenta>)cuentaDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cuenta getCuenta(Cuenta cuenta) {
        return cuentaDao.findById(cuenta.getIdCuenta()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Cuenta cuenta) {
        
        //si el idCuenta es 0 lo inserta
        // si tiene valor el idcuenta lo agrega
        //se toma el dato de credito dentro de cleitne
        Cliente cliente = cuenta.getCliente();
        //inserta el zona antes que el zona
        
        cuenta.setCliente(cliente);
        
        cuentaDao.save(cuenta);
    }
    
    @Override
    @Transactional
    public void delete (Cuenta cuenta) {
        cuentaDao.delete(cuenta);
    }

    

    

}
