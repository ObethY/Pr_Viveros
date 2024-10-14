/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import entitys.Planta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jadey
 */
public class CRUDPlanta {
    public void CreatePlanta(Planta planta) {
        try {
            Planta p;
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            p = planta;
            em.persist(p);
            em.getTransaction().commit();
            em.close();
            emf.close();
            System.out.println("Registro realizado");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
