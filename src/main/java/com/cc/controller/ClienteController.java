/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;


import com.cc.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cc.dao.ClienteDao;
import com.cc.domain.Cliente;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tuleaa
 */
@Controller
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model){
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes",clientes);
        
        return "/cliente/listado";
    }
    
    
    
    
    
    @GetMapping("/cliente/nuevo")
    public String clienteNuevo(Cliente cliente){
        return "/cliente/modificar";
    }
    
    @PostMapping("/cliente/guardar")
    public String clienteGuardar(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/actualiza/{idCliente}")
    public String clienteActualiza(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }
    
    
}
