/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import entitys.Inventario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author AlanG2PC
 */
public class CRUDInventario {

    public void CreateInventario(Inventario inventario) {
        try {
            if (VerifyCode(inventario.getCodigo())) {
                Inventario i;
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                i = inventario;
                em.persist(i);
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
        TypedQuery<Inventario> query = null;
        List<Inventario> results = new ArrayList<Inventario>();
        query = em.createQuery("select i from Inventario i where i.codigo = '" + codigo + "'", Inventario.class);
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
}
