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
    private String zon_descripcion;
    private int zon_superficie;
    
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
    
    public void formZon_zonpla(Zona_Plantas zp){
        this.zon_zonpla.add(zp);
    }
    
    public void dropZon_zonpla(Zona_Plantas zp){
        this.zon_zonpla.remove(zp);
    }
    
    @OneToMany
        @JoinColumn (name="inv_zon", nullable = false)
    private ArrayList<Inventario> zon_inv = new ArrayList<Inventario>();
    
    public void formZon_inv(Inventario in){
        this.zon_inv.add(in);
    }
    
    public void dropZon_inv(Inventario in){
        this.zon_inv.remove(in);
    }
    
    
    @ManyToOne
        @JoinColumn(name="viv_zon", nullable = false)
    private Vivero zon_viv;
    
    public void formZon_viv(Vivero vi){
        this.zon_viv = vi;
    }  

    public Zona(String zon_nombre, String zon_tipo,String descripcion, int zon_superficie) {
        this.zon_descripcion = descripcion;
        this.zon_nombre = zon_nombre;
        this.zon_tipo = zon_tipo;
        this.zon_superficie = zon_superficie;
    }
    
    public Zona() {
        this.zon_descripcion = null;
        this.zon_nombre = "";
        this.zon_tipo = "";
        this.zon_superficie = 0;
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
        return zon_descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.zon_descripcion = descripcion;
    }

    public String getZon_descripcion() {
        return zon_descripcion;
    }

    public void setZon_descripcion(String zon_descripcion) {
        this.zon_descripcion = zon_descripcion;
    }

    public int getZon_superficie() {
        return zon_superficie;
    }

    public void setZon_superficie(int zon_superficie) {
        this.zon_superficie = zon_superficie;
    }

    public ArrayList<Inventario> getZon_inv() {
        return zon_inv;
    }

    public void setZon_inv(ArrayList<Inventario> zon_inv) {
        this.zon_inv = zon_inv;
    }

    public Vivero getZon_viv() {
        return zon_viv;
    }

    public void setZon_viv(Vivero zon_viv) {
        this.zon_viv = zon_viv;
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
