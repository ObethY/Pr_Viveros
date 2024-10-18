/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class Inventario implements Serializable {
    
    @Id
    private String codigo;
    
    private int stock;
    
    @ManyToOne
    @JoinColumn(name="zon_inv",nullable=false)
    private Zona inv_zon;
    
    @ManyToOne
    @JoinColumn(name="pro_inv",nullable=false)
    private Producto inv_pro;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Zona getInv_zon() {
        return inv_zon;
    }

    public void setInv_zon(Zona inv_zon) {
        this.inv_zon = inv_zon;
    }

    public Producto getInv_pro() {
        return inv_pro;
    }

    public void setInv_pro(Producto inv_pro) {
        this.inv_pro = inv_pro;
    }

    
        
}
