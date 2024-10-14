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
public class Zona_Plantas implements Serializable{
 
    @Id @GeneratedValue
    private int id_Zona_Plantas;
    
    private float zonpla_temperatura;
    private int zonpla_humedad;
    Date zonpla_FechaRegistro;
 
    
    @ManyToOne
        @JoinColumn(name="zon_zonpla", nullable = false)
    private Zona zonpla_zon;
    
    public void formZonapla_zon(Zona zo){
        this.zonpla_zon=zo;
    }

    public Zona_Plantas(int id_Zona_Plantas, float zonpla_temperatura, 
            int zonpla_humedad,Date zonpla_FechaRegistro) {
        this.id_Zona_Plantas = id_Zona_Plantas;
        this.zonpla_temperatura = zonpla_temperatura;
        this.zonpla_humedad = zonpla_humedad;
        this.zonpla_FechaRegistro = zonpla_FechaRegistro;
    }
    
     public Zona_Plantas() {
        this.id_Zona_Plantas = 0;
        this.zonpla_temperatura = 0.0f;
        this.zonpla_humedad = 0;
        this.zonpla_FechaRegistro = null;
    }



    public int getId_Zona_Plantas() {
        return id_Zona_Plantas;
    }

    public void setId_Zona_Plantas(int id_Zona_Plantas) {
        this.id_Zona_Plantas = id_Zona_Plantas;
    }

    public float getZonpla_temperatura() {
        return zonpla_temperatura;
    }

    public void setZonpla_temperatura(float zonpla_temperatura) {
        this.zonpla_temperatura = zonpla_temperatura;
    }

    public int getZonpla_humedad() {
        return zonpla_humedad;
    }

    public void setZonpla_humedad(int zonpla_humedad) {
        this.zonpla_humedad = zonpla_humedad;
    }

    public Date getZonpla_FechaRegistro() {
        return zonpla_FechaRegistro;
    }

    public void setZonpla_FechaRegistro(Date zonpla_FechaRegistro) {
        this.zonpla_FechaRegistro = zonpla_FechaRegistro;
    }

    public Zona getZonpla_zon() {
        return zonpla_zon;
    }

    public void setZonpla_zon(Zona zonpla_zon) {
        this.zonpla_zon = zonpla_zon;
    }

    @Override
    public String toString() {
        return "Zona_Plantas{" + "id_Zona_Plantas=" + id_Zona_Plantas + 
                ", zonpla_temperatura=" + zonpla_temperatura + ", zonpla_humedad=" + 
                zonpla_humedad + ", zonpla_FechaRegistro=" + zonpla_FechaRegistro + 
                ", zonpla_zon=" + zonpla_zon + '}';
    }
    
    
    
}
