/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.Service;

import com.cc.domain.Cliente;
import com.cc.domain.Estadistica;
import java.util.List;

/**
 *
 * @author Tuleaa
 */
public interface EstadisticaService {
    
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    public List<Estadistica> getEstadisticas();
    
    
}
