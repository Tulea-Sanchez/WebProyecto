/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.controller;


import com.cc.Service.ClienteService;
import com.cc.Service.CuentaService;
import com.cc.Service.EstadisticaService;
import com.cc.Service.ProductoService;
import com.cc.Service.ProveedorService;
import com.cc.Service.VehiculoService;
import com.cc.Service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cc.dao.ClienteDao;
import com.cc.domain.Cliente;
import com.cc.domain.Cuenta;
import com.cc.domain.Estadistica;
import com.cc.domain.EstadisticaProveedor;
import com.cc.domain.EstadisticaVehiculos;
import com.cc.domain.Producto;
import com.cc.domain.Proveedor;
import com.cc.domain.Vehiculo;
import com.cc.domain.Zona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Tuleaa
 */
@Controller
public class EstadisticaController {
    
    @Autowired
    private CuentaService cuentaService;
    
    @Autowired
    private ZonaService zonaService;
    
    @Autowired
    private EstadisticaService estadisticaService;
    
    @Autowired
    private VehiculoService vehiculoService;
    
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping("estadisticas")
    public String inicio(Model model){
        
        var productos = productoService.getProductos();
        List<Estadistica> ReturnEstadistica = EstadisticaZonas();
        List<EstadisticaVehiculos> ReturnEstadisticaVehiculos = EstadisticaVehiculos();
        List<EstadisticaProveedor> ReturnEstadisticaProveedores = EstadisticaProveedores();
        
        
        model.addAttribute("estadisticasV",ReturnEstadisticaVehiculos);
        model.addAttribute("estadisticasZonas",ReturnEstadistica);
        model.addAttribute("estadisticasProductos",productos);
        model.addAttribute("estadisticasProvee",ReturnEstadisticaProveedores);
        return "/estadistica/listado";
    }
    
    public List<Estadistica> EstadisticaZonas()
    {
    //var estadisticas = cuentaService.getCuentas();
        
        List <Zona> zonas = zonaService.getZonas();
        List <Cuenta> cuentas = cuentaService.getCuentas();
        List<Estadistica> ReturnEstadistica = new ArrayList<Estadistica>();

        int cuentasTotales = 0;
        int SaldoTotal =0;

            for (var z: zonas) {
                
                for (var c: cuentas) {
                    
                    Long cuent = c.getCliente().getZona().getIdZona();
                    Long zon = z.getIdZona();
                    if (cuent == zon)
                    {   
                        System.out.println("Encuentra coincidencia");
                        cuentasTotales++;
                        SaldoTotal = SaldoTotal + c.getSaldo();

                    }
                    
                }

                ReturnEstadistica.add(
                        new Estadistica(z.getDescripcion().toString(),
                        z.getVehiculo().getDescripcion().toString(),
                        cuentasTotales,
                        SaldoTotal));
                
                cuentasTotales = 0;
                SaldoTotal =0;
            }
            

        
        return ReturnEstadistica;
    }
    
    
    public List<EstadisticaVehiculos> EstadisticaVehiculos ()
    {
        //var estadisticas = cuentaService.getCuentas();
        
        List <Zona> zonas = zonaService.getZonas();
        List <Cuenta> cuentas = cuentaService.getCuentas();
        List <Vehiculo> vehiculos = vehiculoService.getVehiculos();
        List<Estadistica> ReturnEstadistica = new ArrayList<Estadistica>();
        List<EstadisticaVehiculos> ReturnEstadisticaVehiculos = new ArrayList<EstadisticaVehiculos>();


        
        for (var v : vehiculos) {
            
            int zonasVehiculo = 0;
            int saldoVehiculo = 0;
            int cuentasVehiculo = 0;
            
            Long veh = v.getIdVehiculo();
            
            for (var z: zonas) {

                Long zonV = z.getVehiculo().getIdVehiculo();
                if (veh == zonV){zonasVehiculo++;}
            }
            
            for (var c: cuentas) {

                    if (c.getCliente().getZona().getVehiculo().getIdVehiculo() == veh){saldoVehiculo = saldoVehiculo + c.getSaldo(); cuentasVehiculo++;}
  
            }
                
            ReturnEstadisticaVehiculos.add(
                        new EstadisticaVehiculos(v.getDescripcion().toString(),
                                                v.getNum_placa().toString(),
                                                zonasVehiculo,
                                                saldoVehiculo,
                                                cuentasVehiculo));

            }
          
        return ReturnEstadisticaVehiculos;
    }
    
    public List<EstadisticaProveedor> EstadisticaProveedores ()
    {
        //var estadisticas = cuentaService.getCuentas();
        
        
        
        List <Producto> productos = productoService.getProductos();
        List <Proveedor> proveedores = proveedorService.getProveedors();
        List<EstadisticaProveedor> estadisticaProveedores = new ArrayList<EstadisticaProveedor>();
        //List<EstadisticaProveedor> ReturnEstadistica = new ArrayList<EstadisticaProveedor>();
        


        
        for (var p : proveedores) {
            System.out.println(p.getDescripcion());
            int cantidadProductos = 0;

            Long provee = p.getIdProveedor();
            
            for (var pr: productos) {

                Long produc = pr.getProveedor().getIdProveedor();
                if (provee == produc){cantidadProductos++;}
            }
              
            estadisticaProveedores.add(new EstadisticaProveedor(Integer.parseInt(p.getIdProveedor().toString()),
                    p.getDescripcion().toString(),
                    cantidadProductos));

            }
          
        return estadisticaProveedores;
    }
    
    
    
    
}
