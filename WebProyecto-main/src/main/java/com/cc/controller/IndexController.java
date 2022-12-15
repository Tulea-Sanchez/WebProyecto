/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cc.dao.ClienteDao;

/**
 *
 * @author Tuleaa
 */
@Controller
public class IndexController {
    
    /*@Autowired
    private ClienteDao clienteDao;*/
    @GetMapping("/")
    public String inicio(Model model){
        
        /*var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos",articulos);*/
        
        return "index";
    }
}
