/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author AlanG2_Laptop
 */

@Entity
public class Vivero implements Serializable {

    @Id
    private String codigo;
    
    private String telefono;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "emp_viv", nullable = false)
    private Empleado viv_emp;
    
    public void formViv_emp(Empleado em){
        this.viv_emp = em;
    }

    @OneToMany
    @JoinColumn(name = "zon_viv", nullable = false)
    private List<Zona> viv_zon = new ArrayList();
    
    public void formViv_zon(Zona zo){
        this.viv_zon.add(zo);
    }

    public void dropViv_zon(Zona zo){
        this.viv_zon.remove(zo);
    }
    
    public Vivero(String codigo,String telefono, String direccion) {
        this.codigo = codigo;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Vivero() {
        this.codigo = null;
        this.telefono = null;
        this.direccion = null;
    }
    
    //Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Empleado getViv_emp() {
        return viv_emp;
    }

    public void setViv_emp(Empleado viv_emp) {
        this.viv_emp = viv_emp;
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setStock(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Zona> getViv_zon() {
        return viv_zon;
    }
    
}
