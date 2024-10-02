/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import entitys.Lista_Empleados_Zona;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
/**
 *
 * @author obeth
 */
public class CRUDLista_Empleados_Zona {
    public void CreateListaEmpleadoZona(Lista_Empleados_Zona ll) {
        Lista_Empleados_Zona l;
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        l = ll;
        em.persist(l);
        em.getTransaction().commit();
// Close the database connection:
        em.close();
        emf.close();
        System.out.println("Lista Empleados Zona registrada");
    }
}
