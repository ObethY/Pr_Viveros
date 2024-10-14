/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Producto implements Serializable{
    
    @Id
    private String pro_codigo;
    private String pro_nombre;
    private String pro_descripcion;
    private String pro_tipo;
    private float pro_precio;
    
    @OneToMany
    @JoinColumn(name="inv_pro", nullable = false)
    private List<Inventario> pro_inv = new ArrayList<Inventario>();
    
    public void formPro_inv(Inventario i){
        getPro_inv().add(i);
    }
    
    public void dropPro_inv(Inventario i){
        getPro_inv().remove(i);
    }
    
    @OneToMany
        @JoinColumn (name= "pla_pro", nullable = false)
    private List<Planta> pro_pla = new ArrayList<Planta>();
    
    public void formPro_pla(Planta p){
        getPro_pla().add(p);
    }
    
    public void dropPro_pla(Planta p){
        getPro_pla().remove(p);
    }

    public Producto(String pro_codigo,String pro_nombre, String pro_descripcion, String pro_tipo, float pro_precio) {
        this.pro_codigo = pro_codigo;
        this.pro_nombre=pro_nombre;
        this.pro_descripcion = pro_descripcion;
        this.pro_tipo = pro_tipo;
        this.pro_precio = pro_precio;
    }

    public Producto() {
        this.pro_codigo = null;
        this.pro_nombre=null;
        this.pro_descripcion = null;
        this.pro_tipo = null;
        this.pro_precio = 0.0f;
    }

    public String getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(String pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }
    
    

    public String getPro_descripcion() {
        return pro_descripcion;
    }

    public void setPro_descripcion(String pro_descripcion) {
        this.pro_descripcion = pro_descripcion;
    }

    public String getPro_tipo() {
        return pro_tipo;
    }

    public void setPro_tipo(String pro_tipo) {
        this.pro_tipo = pro_tipo;
    }

    public float getPro_precio() {
        return pro_precio;
    }

    public void setPro_precio(float pro_precio) {
        this.pro_precio = pro_precio;
    }

    public List<Inventario> getPro_inv() {
        return pro_inv;
    }

    public void setPro_inv(List<Inventario> pro_inv) {
        this.pro_inv = pro_inv;
    }

    public List<Planta> getPro_pla() {
        return pro_pla;
    }

    public void setPro_pla(List<Planta> pro_pla) {
        this.pro_pla = pro_pla;
    }
  
    @Override
    public String toString (){
        return "Producto{" + "codigo: " + pro_codigo + "nombre:"+pro_nombre+", descripcion: " +
                pro_descripcion + ",tipo: " + pro_tipo + "precio: " + pro_precio + "}";
    }
    
}
