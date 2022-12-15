/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;


import com.cc.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cc.dao.VehiculoDao;
import com.cc.domain.Vehiculo;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tuleaa
 */
@Controller
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    @GetMapping("/vehiculo/listado")
    public String inicio(Model model){       
        var vehiculos = vehiculoService.getVehiculos();
        model.addAttribute("vehiculos",vehiculos);       
        return "/vehiculo/listado";
    }  
    
    @GetMapping("/vehiculo/nuevo")
    public String vehiculoNuevo(Vehiculo vehiculo){
        return "/vehiculo/modificar";
    }
    
    @PostMapping("/vehiculo/guardar")
    public String vehiculoGuardar(Vehiculo vehiculo){
        vehiculoService.save(vehiculo);
        return "redirect:/vehiculo/listado";
    }
    
    @GetMapping("/vehiculo/actualiza/{idVehiculo}")
    public String vehiculoActualiza(Vehiculo vehiculo, Model model){
        vehiculo = vehiculoService.getVehiculo(vehiculo);
        model.addAttribute("vehiculo", vehiculo);
        return "/vehiculo/modificar";
    }
    
    
    @GetMapping("/vehiculo/elimina/{idVehiculo}")
    public String clienteElimina(Vehiculo vehiculo){
        vehiculoService.delete(vehiculo);
        return "redirect:/vehiculo/listado";
    }
    
    
    
}
