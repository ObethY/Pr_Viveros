/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import entitys.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author jadey
 */
public class CRUDProducto {
     public void CreateProducto(Producto producto) {
        try {
            if (VerifyCode(producto.getPro_codigo())) {
                Producto p;
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                p = producto;
                em.persist(p);
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
        TypedQuery<Producto> query = null;
        List<Producto> results = new ArrayList<Producto>();
        query = em.createQuery("select p from Producto p where p.pro_codigo = '" + codigo + "'", Producto.class);
        results = query.getResultList();
        System.out.println("Objetos encontrados: " + results);
        em.close();
        emf.close();
        if (results.isEmpty()) {
            System.out.println("Sin ocurrencias");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Ese código ya pertenece a un producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
