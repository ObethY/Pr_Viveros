/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pk_modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author AlanG2_Laptop
 */
public class Vivero implements Serializable {

    @Id
    private String telefono;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "emp_viv", nullable = false)
    private Empleado viv_emp;

    @OneToMany
    @JoinColumn(name = "zon_viv", nullable = false)
    private List<Zona> viv_zon = new ArrayList();

    public Vivero(String telefono, String direccion) {
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Vivero() {
        this.telefono = null;
        this.direccion = null;
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
