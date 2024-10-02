/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author obeth
 */

@Entity
public class Zona implements Serializable{
    
    @Id
    private String zon_nombre;
    
    private String zon_tipo;
    private String descripcion;
    
    @OneToMany
        @JoinColumn (name="lis_zon", nullable = false)
    private ArrayList<Lista_Empleados_Zona> zon_lis = new ArrayList<Lista_Empleados_Zona>();
    
    public void formZon_lis(Lista_Empleados_Zona li){
        this.zon_lis.add(li);
    }
    
    public void dropZon_lis(Lista_Empleados_Zona li){
        this.zon_lis.remove(li);
    }
    
    @OneToMany
        @JoinColumn (name="zonpla_zon", nullable = false)
    private ArrayList<Zona_Plantas> zon_zonpla = new ArrayList<Zona_Plantas>();
    
    
    @ManyToOne
        @JoinColumn(name="viv_zon", nullable = false)
    private Vivero zon_viv;
    
    public void formZon_viv(Vivero vi){
        this.zon_viv = vi;
    }
    
    @ManyToOne
        @JoinColumn(name="inv_zon", nullable = false)
    private Inventario zon_inv;
    

    public Zona(String zon_nombre, String zon_tipo,String descripcion) {
        this.descripcion = descripcion;
        this.zon_nombre = zon_nombre;
        this.zon_tipo = zon_tipo;
    }
    
    public Zona() {
        this.descripcion = null;
        this.zon_nombre = "";
        this.zon_tipo = "";
    }
    
    public void PrintListaEmpleados(){
        System.out.println("Salas: "+getZon_lis().size());
        
        for (int i=0;i<getZon_lis().size();i++) {
            System.out.println(getZon_lis().get(i));
        }
    }
    
    public void PrintZonaPlantas(){
        System.out.println("Salas: "+getZon_zonpla().size());
        
        for (int i=0;i<getZon_zonpla().size();i++) {
            System.out.println(getZon_zonpla().get(i));
        }
    }
    
    
    
    //Getters y setters

    public String getZon_nombre() {
        return zon_nombre;
    }

    public void setZon_nombre(String zon_nombre) {
        this.zon_nombre = zon_nombre;
    }

    public String getZon_tipo() {
        return zon_tipo;
    }

    public void setZon_tipo(String zon_tipo) {
        this.zon_tipo = zon_tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public ArrayList<Lista_Empleados_Zona> getZon_lis() {
        return zon_lis;
    }

    public void setZon_lis(ArrayList<Lista_Empleados_Zona> zon_lis) {
        this.zon_lis = zon_lis;
    }

    public ArrayList<Zona_Plantas> getZon_zonpla() {
        return zon_zonpla;
    }

    public void setZon_zonpla(ArrayList<Zona_Plantas> zon_zonpla) {
        this.zon_zonpla = zon_zonpla;
    }

    @Override
    public String toString() {
        return "Zona{" + "nombre=" + zon_nombre + ", tipo=" +
                zon_tipo + ", Lista Empleado=" + zon_lis + ", Zona plantas=" +
                zon_zonpla + '}';
    }
    
    
}
