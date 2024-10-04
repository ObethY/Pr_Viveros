/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author obeth
 */
@Entity
public class Zona_Plantas implements Serializable{
 
    @Id @GeneratedValue
    private int id_Zona_Plantas;
    
    private float zonpla_temperatura;
    private String zonpla_humedad;
 
    
    @ManyToOne
        @JoinColumn(name="zon_zonpla", nullable = false)
    private Zona zonpla_zon;

    public Zona_Plantas(int id_Zona_Plantas, float zonpla_temperatura, 
            String zonpla_humedad) {
        this.id_Zona_Plantas = id_Zona_Plantas;
        this.zonpla_temperatura = zonpla_temperatura;
        this.zonpla_humedad = zonpla_humedad;
    }
    
     public Zona_Plantas() {
        this.id_Zona_Plantas = 0;
        this.zonpla_temperatura = 0.0f;
        this.zonpla_humedad = "";
    }

    @Override
    public String toString() {
        return "Zona_Plantas{" + "id_Zona_Plantas=" + id_Zona_Plantas +
                ", zonpla_temperatura=" + zonpla_temperatura + ", zonpla_humedad=" + 
                zonpla_humedad + ", zonpla_zon=" + zonpla_zon + '}';
    }
    
    
}
