/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.Service;

import com.cc.domain.Zona;
import java.util.List;

/**
 *
 * @author Tuleaa
 */
public interface ZonaService {
    
    //metodos para crear un crud .. CREATE, READ, UPDATE, DELETE
    public List<Zona> getZonas();
    
    public Zona getZona(Zona zona);
    
    public void save (Zona zona);
    
    public void delete (Zona zona);
}
