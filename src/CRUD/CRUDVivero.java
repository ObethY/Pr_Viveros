/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import entitys.Vivero;
import entitys.Zona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
/**
 *
 * @author obeth
 */
public class CRUDVivero {
    
    public List readVivero(String field, String crit) {

        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Vivero> query = null;
        List<Vivero> results = new ArrayList<Vivero>();
        if (crit.equals("")) {
            query = em.createQuery("select v from Vivero v", Vivero.class);
        } else {
            query = em.createQuery("select v from Vivero v where v." + field.toLowerCase() + 
                " like '%" + crit + "%'", Vivero.class);
        }
            
        results = query.getResultList();
        System.out.println("Objetos encontrados: " + results.size());      
        // Close the database connection:
        em.close();
        emf.close();
        return results;
    }
     
      public Vivero opBuscar (String codigo) {
        Vivero v = null;
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
            v = em.find(Vivero.class, codigo);
        // Close the database connection:
        em.close();
        emf.close();
        return v;
    }
}
