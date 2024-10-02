/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author obeth
 */

@Entity
public class Lista_Empleados_Zona implements Serializable {
 
    @Id @GeneratedValue
    private int id_Lista;
    
    private Date lis_fecha_Inicio;
    private Date lis_fecha_Final;
    
    @ManyToOne
        @JoinColumn(name="emp_lis", nullable = false)
    private Empleado lis_emp;
    
    @ManyToOne
        @JoinColumn(name="zon_lis", nullable = false)
    private Zona lis_zon;

    public Lista_Empleados_Zona(int id_Lista, Date lis_fecha_Inicio, Date lis_fecha_Final) {
        this.id_Lista = id_Lista;
        this.lis_fecha_Inicio = lis_fecha_Inicio;
        this.lis_fecha_Final = lis_fecha_Final;
        //this.lis_emp = lis_emp;
    }
    
    public Lista_Empleados_Zona() {
        this.id_Lista = 0;
        this.lis_fecha_Inicio = null;
        this.lis_fecha_Final = null;
        //this.lis_emp = null;
    }

    @Override
    public String toString() {
        return "Lista_Empleados_Zona{" + "id_Empleado=" + id_Lista + ", fecha_Inicio=" 
                + lis_fecha_Inicio + ", fecha_Final=" + lis_fecha_Final + ", lis_emp=" + lis_emp + '}';
    }
    
    public void formLis_emp(Empleado e){
        this.lis_emp = e;
    }
    
    //gettesrs y setters

    public int getId_Lista() {
        return id_Lista;
    }

    public void setId_Lista(int id_Lista) {
        this.id_Lista = id_Lista;
    }

    public Date getLis_fecha_Inicio() {
        return lis_fecha_Inicio;
    }

    public void setLis_fecha_Inicio(Date lis_fecha_Inicio) {
        this.lis_fecha_Inicio = lis_fecha_Inicio;
    }

    public Date getLis_fecha_Final() {
        return lis_fecha_Final;
    }

    public void setLis_fecha_Final(Date lis_fecha_Final) {
        this.lis_fecha_Final = lis_fecha_Final;
    }

    public Empleado getLis_emp() {
        return lis_emp;
    }

    public void setLis_emp(Empleado lis_emp) {
        this.lis_emp = lis_emp;
    }

    
    
}
