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
import com.cc.domain.Estadistica;


// crea la conexion entre la base de datos y la parte grafica

@Service
public class EstadisticaServiceImpl implements EstadisticaService {   

    
    @Override
    @Transactional(readOnly = true)
    public List<Estadistica> getEstadisticas() {
        return null;
    }
    
    

    

}
