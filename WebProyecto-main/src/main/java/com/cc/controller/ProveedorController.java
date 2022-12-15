/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;


import com.cc.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cc.dao.ProveedorDao;
import com.cc.domain.Proveedor;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tuleaa
 */
@Controller
public class ProveedorController {
    
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping("/proveedor/listado")
    public String inicio(Model model){
        
        var proveedors = proveedorService.getProveedors();
        model.addAttribute("proveedors",proveedors);
        
        return "/proveedor/listado";
    }
    
    
    @GetMapping("/proveedor/nuevo")
    public String proveedorNuevo(Proveedor proveedor){
        return "/proveedor/modificar";
    }
    
    @PostMapping("/proveedor/guardar")
    public String proveedorGuardar(Proveedor proveedor){
        proveedorService.save(proveedor);
        return "redirect:/proveedor/listado";
    }
    
    @GetMapping("/proveedor/actualiza/{idProveedor}")
    public String proveedorActualiza(Proveedor proveedor, Model model){
        proveedor = proveedorService.getProveedor(proveedor);
        model.addAttribute("proveedor", proveedor);
        return "/proveedor/modificar";
    }
    
    @GetMapping("/proveedor/elimina/{idProveedor}")
    public String clienteElimina(Proveedor proveedor){
        proveedorService.delete(proveedor);
        return "redirect:/proveedor/listado";
    }
    
}
