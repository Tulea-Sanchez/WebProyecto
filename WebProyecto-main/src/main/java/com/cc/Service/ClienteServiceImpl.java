/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cc.Service;

import com.cc.dao.ClienteDao;
import com.cc.domain.Cliente;
import com.cc.domain.Zona;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cc.dao.ProductoDao;
import com.cc.dao.ZonaDao;


// crea la conexion entre la base de datos y la parte grafica

@Service
public class ClienteServiceImpl implements ClienteService {
    
    
    //si el objeto esta en memoria no se crea// pero si no existe lo crea
    @Autowired
    private ClienteDao clienteDao;
       
    @Autowired
    private ZonaDao zonaDao;
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    
    //aqui va la implementacion de credito
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Cliente cliente) {
        //si el idCliente es 0 lo inserta
        // si tiene valor el idcliente lo agrega
        //se toma el dato de credito dentro de cleitne
        Zona zona = cliente.getZona();
        //inserta el zona antes que el zona
        zona = zonaDao.save(zona);
        cliente.setZona(zona);      
        clienteDao.save(cliente);
    }
    
    @Override
    @Transactional
    public void delete (Cliente cliente) {
        clienteDao.delete(cliente);
    }

    

}
