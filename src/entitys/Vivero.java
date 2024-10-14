/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import java.util.ArrayList;
/**
 *
 * @author AlanG2_Laptop
 */

@Entity
public class Vivero implements Serializable {

    @Id
    private String codigo;   
    private String telefono;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private String codigoPostal;

    @ManyToOne
    @JoinColumn(name = "emp_viv", nullable = false)
    private Empleado viv_emp;
    
    public void formViv_emp(Empleado em){
        this.viv_emp = em;
    }

    @OneToMany
    @JoinColumn(name = "zon_viv", nullable = false)
    private List<Zona> viv_zon = new ArrayList<Zona>();
    
    public void formViv_zon(Zona zo){
        getViv_zon().add(zo);
    }

    public void dropViv_zon(Zona zo){
        getViv_zon().remove(zo);
    }

    public Vivero(String codigo, String telefono, String calle, String numero, String colonia, String ciudad, String estado, String codigoPostal) {
        this.codigo = codigo;
        this.telefono = telefono;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }
    
   public Vivero() {
        this.codigo = null;
        this.telefono = null;
        this.calle = null;
        this.numero = null;
        this.colonia = null;
        this.ciudad = null;
        this.estado = null;
        this.codigoPostal = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Empleado getViv_emp() {
        return viv_emp;
    }

    public void setViv_emp(Empleado viv_emp) {
        this.viv_emp = viv_emp;
    }

    public List<Zona> getViv_zon() {
        return viv_zon;
    }

    public void setViv_zon(List<Zona> viv_zon) {
        this.viv_zon = viv_zon;
    }

    public String mostrarDireccionCompleta() {
        return calle + " " + numero + ", " + colonia + ", " + ciudad + ", " + estado + ", C.P. " + codigoPostal;
    }
    
    @Override
    public String toString (){
        return "Vivero{ " + "codigo: " + codigo + ", telefono: " +
                telefono + ", direccion: " + mostrarDireccionCompleta() + "}";
    }
}
