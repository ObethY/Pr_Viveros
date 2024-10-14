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
import javax.swing.JOptionPane;
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
            query = em.createQuery("select v from Vivero v where v." + field.toLowerCase()
                    + " like '%" + crit + "%'", Vivero.class);
        }

        results = query.getResultList();
        System.out.println("Objetos encontrados: " + results.size());
        // Close the database connection:
        em.close();
        emf.close();
        return results;
    }

    public Vivero opBuscar(String codigo) {
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

    public void CreateVivero(Vivero vivero) {
        try {
            if (VerifyCode(vivero.getCodigo())) {
                Vivero v;
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                v = vivero;
                em.persist(v);
                em.getTransaction().commit();
                em.close();
                emf.close();
                JOptionPane.showMessageDialog(null, "Registro realizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public boolean VerifyCode(String codigo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
        // Retrieve Proveedor objects from the database:
        TypedQuery<Vivero> query = null;
        List<Vivero> results = new ArrayList<Vivero>();
        query = em.createQuery("select v from Vivero v where v.codigo = '" + codigo + "'", Vivero.class);
        results = query.getResultList();
        System.out.println("Objetos encontrados: " + results);
        em.close();
        emf.close();
        if (results.isEmpty()) {
            System.out.println("Sin ocurrencias");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ese código ya pertenece a un vivero", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        }
      
      public List<Vivero> getViveros() {
        // Abrir una conexión a la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();

        // Crear y ejecutar una consulta para obtener todos los empleados
        TypedQuery<Vivero> query = em.createQuery("SELECT v FROM Vivero v", Vivero.class);
        List<Vivero> viveros = query.getResultList();

        // Cerrar la conexión
        em.close();
        emf.close();

        return viveros;
    }
}
