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
import org.springframework.web.bind.annotation.RequestParam;

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
    
    
    @PostMapping("/cobro/abonar/")
    public String Abonar(@RequestParam int idCuenta,@RequestParam int saldo,@RequestParam int abono, Model model){
        
        Cuenta cuenta = cuentaService.getCuenta(Long.parseLong(idCuenta+""));
        
        int oldSaldo = cuenta.getSaldo();
        cuenta.setSaldo(oldSaldo - abono);
        cuentaService.save(cuenta);
        
        model.addAttribute("cuentas", RetornaCuentas(cuenta.getCliente().getZona()));
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
    
    @GetMapping("/cobro/check/{idCuenta}")
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
        return "/cobro/modificar/";
    }
    
    
    
    public List <Cuenta> RetornaCuentas(Zona zona){
        
        var auxiliares = cuentaService.getCuentas();
        List <Cuenta> cuentas = cuentaService.getCuentas();
        var ReturnCuentas = cuentaService.returnNull();
        cuentas.removeAll(auxiliares);
        
        
        for (var c: auxiliares) {
            
            Long cuent = c.getCliente().getZona().getIdZona();
            Long zon = zona.getIdZona();
            System.out.println(zona.getIdZona() + "zona retornacuentas");
            //assertThat(l1.equals(l2)).isTrue();
            
            if (cuent == zon)
            {
                System.out.println("entra al if");
                cuentas.add(cuentaService.getCuenta(c));
                System.out.println("cuenta agregada" + c.getCliente());

            }
        }
        
        
        return cuentas;
    }
    
    
}
