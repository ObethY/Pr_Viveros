/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Planta implements Serializable{
    
    @Id
    private String pla_nombre;
    private String pla_clima;
    private String pla_cuidados;
    private String pla_humedad;
    private String pla_luz;
    
    @ManyToOne
        @JoinColumn (name = "pro_pla", nullable = false)
    private Producto pla_pro;

    public Planta(String pla_nombre, String pla_clima, String pla_cuidados, String pla_humedad, String pla_luz) {
        this.pla_nombre = pla_nombre;
        this.pla_clima = pla_clima;
        this.pla_cuidados = pla_cuidados;
        this.pla_humedad = pla_humedad;
        this.pla_luz = pla_luz;
    }
    
    public Planta() {
        this.pla_nombre = null;
        this.pla_clima = null;
        this.pla_cuidados = null;
        this.pla_humedad = null;
        this.pla_luz = null;
    }

    public String getPla_nombre() {
        return pla_nombre;
    }

    public void setPla_nombre(String pla_nombre) {
        this.pla_nombre = pla_nombre;
    }

    public String getPla_clima() {
        return pla_clima;
    }

    public void setPla_clima(String pla_clima) {
        this.pla_clima = pla_clima;
    }

    public String getPla_cuidados() {
        return pla_cuidados;
    }

    public void setPla_cuidados(String pla_cuidados) {
        this.pla_cuidados = pla_cuidados;
    }

    public String getPla_humedad() {
        return pla_humedad;
    }

    public void setPla_humedad(String pla_humedad) {
        this.pla_humedad = pla_humedad;
    }

    public String getPla_luz() {
        return pla_luz;
    }

    public void setPla_luz(String pla_luz) {
        this.pla_luz = pla_luz;
    }
    
    
    
}
