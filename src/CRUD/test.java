/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import entitys.Empleado;
import entitys.Lista_Empleados_Zona;
import entitys.Planta;
import entitys.Vivero;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author obeth
 */
public class test {
     public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf= Persistence.createEntityManagerFactory
        ("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Planta P1 = new Planta("Bugambilia","Templado", "Muchos",
                "si", "poca");

        
        em.persist(P1);
        /*
        Empleado e1 = new Empleado("CADO031002HHGLZABA9", "Obeth", "7713185145");
        Empleado e2 = new Empleado("SRMZPT03090921M800", "Patricia", "7712926603");
        Empleado e3 = new Empleado("CASF884HHSL98AASD122", "Alejandro", "5512324321");
        Empleado e4 = new Empleado("DFCDSDFWEETTV5ASD234", "Obeth", "5512234526");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaini = null,fechafin = null;
        Date fechaini1 = null,fechafin1 = null;
        Date fechaini2 = null,fechafin2 = null;
        Date fechaini3 = null,fechafin3 = null;
        
        try {
            fechaini = dateFormat.parse("2024-12-12");
            fechafin = dateFormat.parse("2024-15-12");
            fechaini1 = dateFormat.parse("2024-23-12");
            fechafin1 = dateFormat.parse("2025-11-1");
            fechaini2 = dateFormat.parse("2024-10-12");
            fechafin2 = dateFormat.parse("2024-11-12");
            fechaini3 = dateFormat.parse("2024-1-12");
            fechafin3 = dateFormat.parse("2024-2-12");
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        Lista_Empleados_Zona l1 = new Lista_Empleados_Zona(0, fechaini, fechafin);
        Lista_Empleados_Zona l2 = new Lista_Empleados_Zona(0, fechaini1, fechafin1);
        Lista_Empleados_Zona l3 = new Lista_Empleados_Zona(0, fechaini2, fechafin2);
        Lista_Empleados_Zona l4 = new Lista_Empleados_Zona(0, fechaini3, fechafin3);
     
        e1.formEmp_lis(l1);
        e2.formEmp_lis(l2);
        e3.formEmp_lis(l3);
        e4.formEmp_lis(l4);
        
        l1.formLis_emp(e1);
        l2.formLis_emp(e2);
        l3.formLis_emp(e3);
        l4.formLis_emp(e4);
        
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);
        
        em.persist(l1);
        em.persist(l2);
        em.persist(l3);
        em.persist(l4);
        
        */
        em.getTransaction().commit();
// Close the database connection:
        em.close();
        emf.close();
    }
}
