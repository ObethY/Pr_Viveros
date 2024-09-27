/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pk_modelo;
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
@Entity
public class Inventario implements Serializable {
    @Id
    private int stock;
    @ManyToOne
    @JoinColumn(name="zon_inv",nullable=false)
    private Zona inv_zon;
    
    @ManyToOne
    @JoinColumn(name="pro_inv",nullable=false)
    private Producto inv_pro;

    public Inventario(int stock) {
        this.stock = stock;
    }
    public Inventario() {
        this.stock = 0;
    }

    public Producto getInv_pro() {
        return inv_pro;
    }

    public void setInv_pro(Producto inv_pro) {
        this.inv_pro = inv_pro;
    }
    
}
