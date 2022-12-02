/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.Service;

import com.cc.domain.Vehiculo;
import java.util.List;

/**
 *
 * @author Tuleaa
 */
public interface VehiculoService {
    
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    public List<Vehiculo> getVehiculos();
    
    public Vehiculo getVehiculo(Vehiculo vehiculo);
    
    public void save (Vehiculo vehiculo);
    
    public void delete (Vehiculo vehiculo);
}
