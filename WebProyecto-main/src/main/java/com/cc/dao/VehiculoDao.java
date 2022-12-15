/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.dao;

import com.cc.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tuleaa
 */
public interface VehiculoDao extends JpaRepository<Vehiculo,Long> {
        
}
