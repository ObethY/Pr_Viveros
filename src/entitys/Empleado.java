/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
/**
 *
 * @author obeth
 */
@Entity
public class Empleado implements Serializable{
    
    @Id
    private String emp_ine;
    
    private String emp_nombre;
    private String emp_telefono;
    
    @OneToMany
        @JoinColumn (name="lis_emp", nullable = false)
    private ArrayList<Lista_Empleados_Zona> emp_lis = new ArrayList<Lista_Empleados_Zona>();

    public Empleado(String emp_ine, String emp_nombre, String emp_telefono) {
        this.emp_ine = emp_ine;
        this.emp_nombre = emp_nombre;
        this.emp_telefono = emp_telefono;
    }
    
    public Empleado() {
        this.emp_ine = "";
        this.emp_nombre = "";
        this.emp_telefono = "";
    }

    @Override
    public String toString() {
        return "Empleado{" + "ine=" + emp_ine + ", nombre=" + emp_nombre + ", telefono=" +
                emp_telefono + ", emp_lis=" + emp_lis + '}';
    }
    
    public void formEmp_lis(Lista_Empleados_Zona l1){
        getEmp_lis().add(l1);
    }
    
    public void dropEmp_lis(Lista_Empleados_Zona l1){
        getEmp_lis().remove(l1);
    }
    
    public void PrintListaEmpleados(){
        System.out.println("Salas: "+getEmp_lis().size());
        
        for (int i=0;i<getEmp_lis().size();i++) {
            System.out.println(getEmp_lis().get(i));
        }
    }
    
    //Getters y setters

    public String getEmp_ine() {
        return emp_ine;
    }

    public void setEmp_ine(String emp_ine) {
        this.emp_ine = emp_ine;
    }

    public String getEmp_nombre() {
        return emp_nombre;
    }

    public void setEmp_nombre(String emp_nombre) {
        this.emp_nombre = emp_nombre;
    }

    public String getEmp_telefono() {
        return emp_telefono;
    }

    public void setEmp_telefono(String emp_telefono) {
        this.emp_telefono = emp_telefono;
    }

    public ArrayList<Lista_Empleados_Zona> getEmp_lis() {
        return emp_lis;
    }

    public void setEmp_lis(ArrayList<Lista_Empleados_Zona> emp_lis) {
        this.emp_lis = emp_lis;
    }


}
