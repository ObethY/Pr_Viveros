/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Producto implements Serializable{
    
    @Id
    private String pro_codigo;
    private String pro_descripcion;
    private float pro_precio;
    private int pro_stock;
    
    @ManyToOne
    @JoinColumn(name="inv_pro", nullable = false)
    private Inventario pro_inv; 
    
    @ManyToOne
        @JoinColumn (name= "pla_pro", nullable = false)
    private Planta pro_pla;

    public Producto(String pro_codigo, String pro_descripcion, float pro_precio, int pro_stock) {
        this.pro_codigo = pro_codigo;
        this.pro_descripcion = pro_descripcion;
        this.pro_precio = pro_precio;
        this.pro_stock = pro_stock;
    }
    
    public Producto() {
        this.pro_codigo = null;
        this.pro_descripcion = null;
        this.pro_precio = 0.0f;
        this.pro_stock = 0;
    }

    public String getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(String pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_descripcion() {
        return pro_descripcion;
    }

    public void setPro_descripcion(String pro_descripcion) {
        this.pro_descripcion = pro_descripcion;
    }

    public float getPro_precio() {
        return pro_precio;
    }

    public void setPro_precio(float pro_precio) {
        this.pro_precio = pro_precio;
    }

    public int getPro_stock() {
        return pro_stock;
    }

    public void setPro_stock(int pro_stock) {
        this.pro_stock = pro_stock;
    }
    
}
