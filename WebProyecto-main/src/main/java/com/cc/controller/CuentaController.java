/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;


import com.cc.Service.CuentaService;
import com.cc.Service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cc.domain.Cuenta;
import com.cc.domain.Zona;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tuleaa
 */
@Controller
public class CuentaController {
    
    @Autowired
    private CuentaService cuentaService;
    
    @Autowired
    private ZonaService zonaService;
    
    @GetMapping("/cobro/zonas")
    public String inicio(Model model){
        var zonas = zonaService.getZonas();
        model.addAttribute("zonas",zonas);
        
        return "/cobro/zonas";
    }
    
    @GetMapping("/cobro/listado/{idZona}")
    public String IniciarControl(Model model, Zona zona){
        
        var auxiliares = cuentaService.getCuentas();
        List <Cuenta> cuentas = cuentaService.getCuentas();
        var ReturnCuentas = cuentaService.returnNull();
        cuentas.removeAll(auxiliares);
        
        int SaldoTotal =0;
        
        
        for (var c: auxiliares) {
            
            Long cuent = c.getCliente().getZona().getIdZona();
            Long zon = zona.getIdZona();

            //assertThat(l1.equals(l2)).isTrue();
            
            if (cuent == zon)
            {
                System.out.println("entra al if");
                cuentas.add(cuentaService.getCuenta(c));
                SaldoTotal = SaldoTotal + c.getSaldo();
                System.out.println("sale al if");
            }
        }
        if (cuentas.size() != 0){model.addAttribute("cuentas",cuentas);}
        else {model.addAttribute("cuentas",ReturnCuentas);}
        model.addAttribute("SaldoTotal",SaldoTotal);
        model.addAttribute("totalCuentas",cuentas.size());
        
        return "/cobro/listado";
    }
    
    
    public Model returnVar (Zona zona){
        
        Model model = null;
        var auxiliares = cuentaService.getCuentas();
        List <Cuenta> cuentas = cuentaService.getCuentas();
        var ReturnCuentas = cuentaService.returnNull();
        cuentas.removeAll(auxiliares);
        
        int SaldoTotal =0;
        
        
        for (var c: auxiliares) {
            
            Long cuent = c.getCliente().getZona().getIdZona();
            Long zon = zona.getIdZona();

            //assertThat(l1.equals(l2)).isTrue();
            
            if (cuent == zon)
            {
                System.out.println("entra al if");
                cuentas.add(cuentaService.getCuenta(c));
                SaldoTotal = SaldoTotal + c.getSaldo();
                System.out.println("sale al if");
            }
        }
        if (cuentas.size() != 0){model.addAttribute("cuentas",cuentas);}
        else {model.addAttribute("cuentas",ReturnCuentas);}
        model.addAttribute("SaldoTotal",SaldoTotal);
        model.addAttribute("totalCuentas",cuentas.size());
        
        return model;
    }
    
    
    @GetMapping("/cobro/abonar/{abono}")
    public String Abonar(Model model, Cuenta cuenta, int abono){
        
        
        int nuevoSaldo = cuenta.getSaldo() - abono;
        cuenta.setSaldo(nuevoSaldo);
        cuentaService.save(cuenta);

        Model cuentas = returnVar(cuenta.getCliente().getZona());
       
        return "/cobro/listado/";
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
        System.out.println(cuenta.getIdCuenta() + "id enviado" );
        cuenta = cuentaService.getCuenta(cuenta.getIdCuenta());
        model.addAttribute("cuenta", cuenta);
        return "/cobro/modificar";
    }
    
    @GetMapping("/cobro/monto/{idCuenta}")
    public String cuentaAbona(Cuenta cuenta, Model model){
        System.out.println(cuenta + "id enviado" );
        cuenta = cuentaService.getCuenta(cuenta);
        model.addAttribute("cuenta", cuenta);
        return "/cobro/modificar/"+cuenta.getIdCuenta().toString();
    }
    
    
}
