/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;


import com.cc.Service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cc.domain.Cuenta;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tuleaa
 */
@Controller
public class CuentaController {
    
    @Autowired
    private CuentaService cuentaService;
    
    @GetMapping("/cobro/listado")
    public String inicio(Model model){
        
        var cuentas = cuentaService.getCuentas();
        model.addAttribute("cuentas",cuentas);
        
        var SaldoTotal=0;
        for (var c: cuentas) {
            SaldoTotal+=c.getSaldo();
        }
        
        model.addAttribute("SaldoTotal",SaldoTotal);
        model.addAttribute("totalCuentas",cuentas.size());
        return "/cobro/listado";
    }
    
    
    
    
    
    @GetMapping("/cobro/nuevo")
    public String cuentaNuevo(Cuenta cuenta){
        return "/cobro/modificar";
    }
    
    @PostMapping("/cobro/guardar")
    public String cuentaGuardar(Cuenta cuenta){
        cuentaService.save(cuenta);
        return "redirect:/cobro/listado";
    }
    
    @GetMapping("/cobro/modificar/{idCuenta}")
    public String cuentaActualiza(Cuenta cuenta, Model model){
        cuenta = cuentaService.getCuenta(cuenta);
        model.addAttribute("cuenta", cuenta);
        return "/cobro/modificar";
    }
    
    
}
