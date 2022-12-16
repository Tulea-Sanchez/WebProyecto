/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;

import com.cc.Service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cc.domain.Zona;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tuleaa
 */
@Controller
public class ZonaController {

    @Autowired
    private ZonaService zonaService;

    @GetMapping("/zona/listado")
    public String inicio(Model model) {
        var zonas = zonaService.getZonas();
        model.addAttribute("zonas", zonas);
        return "/zona/listado";
    }

    @GetMapping("/zona/nuevo")
    public String zonaNuevo(Zona zona) {
        return "/zona/modificar";
    }

    @PostMapping("/zona/guardar")
    public String zonaGuardar(Zona zona) {
        zonaService.save(zona);
        return "redirect:/zona/listado";
    }

    @GetMapping("/zona/actualiza/{idZona}")
    public String zonaActualiza(Zona zona, Model model) {
        zona = zonaService.getZona(zona);
        model.addAttribute("zona", zona);
        return "/zona/modificar";
    }

    @GetMapping("/zona/elimina/{idZona}")
    public String clienteElimina(Zona zona) {
        zonaService.delete(zona);
        return "redirect:/zona/listado";
    }

}
