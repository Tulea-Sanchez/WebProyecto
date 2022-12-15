/*
package com.cc.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

 
@Data
@Entity
@Table(name="productos")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    
    @JoinColumn(name="id_proveedor", referencedColumnName="id_proveedor")
    @ManyToOne
    private Proveedor proveedor;
    private String descripcion;
    private int cantidad,precio_unit;

    public Producto(Proveedor proveedor, String descripcion, int cantidad, int precio_unit) {
        this.proveedor = proveedor;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_unit = precio_unit;
    }

    


    public Producto() {
    }

}

*/  




/*NOTA= DE AQUÍ PARA ARRIBA ERA COMO ESTABA ESTA CLASE, DE AQUÍ PARA ABAJO ESTAN LOS CAMBIOS QUE REALICE*/






package com.cc.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="productos")
public class Producto implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    
    
    private String descripcion;
    private int cantidad, precio_unit;

    public Producto(String descripcion, int cantidad, int precio_unit) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_unit = precio_unit;
    }
    
    

    public Producto() {
    }
    

}
