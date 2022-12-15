/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;


import com.cc.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cc.dao.ProveedorDao;
import com.cc.domain.Producto;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tuleaa
 */
@Controller
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/producto/listado")
    public String inicio(Model model){
        
        var productos = productoService.getProductos();
        model.addAttribute("productos",productos);
        
        return "/producto/listado";
    }
    
    
    @GetMapping("/producto/nuevo")
    public String productoNuevo(Producto producto){
        return "/producto/modificar";
    }
    
    @PostMapping("/producto/guardar")
    public String productoGuardar(Producto producto){
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/producto/actualiza/{idProducto}")
    public String productoActualiza(Producto producto, Model model){
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modificar";
    }
    
    @GetMapping("/producto/elimina/{idProducto}")
    public String clienteElimina(Producto producto){
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
    
    
}
