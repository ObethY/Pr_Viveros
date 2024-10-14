/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import entitys.Zona_Plantas;
import entitys.Zona;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author obeth
 */
public class CRUDZona_Plantas {
     public boolean CreateZona_Plantas(Zona_Plantas zonpla, String zona) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
        boolean result = false;

        try {
            em.getTransaction().begin();

            // Buscar el Vivero existente por su ID
            Zona zo = em.find(Zona.class, zona);
            if (zo == null) {
                System.out.println("Zona no encontrada modifique la zona:" + zona);
                return false;  // Retorna false si el vivero no se encuentra
            }
            // Crear la nueva lista y se relaciona con la zona y con el empleado
            zonpla.formZonapla_zon(zo);  // Relaciona la lista con el empleado
            zo.formZon_zonpla(zonpla);  // Relaciona el empleado con la zona 

            
            
            em.persist(zonpla);
            em.getTransaction().commit();
            result = true;  // Operación exitosa

            System.out.println("Zona Platas Registrada y relacionada con: " + zo.getZon_nombre());
        } catch (Exception e) {
            // Si ocurre algún error, hacemos rollback y manejamos la excepción
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar la Zona: " + e.getMessage());
            result = false;  // Ocurrió un error
        } finally {
            em.close();
            emf.close();
        }
        return result;  // Retorna true si la operación fue exitosa, false en caso de fallo
    }
     
       public List getZonaPlanta(String field, String crit){
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
            // Retrieve Proveedor objects from the database:
            TypedQuery<Zona_Plantas> query = null;
            List<Zona_Plantas> results = new ArrayList<Zona_Plantas>();
            if (crit.equals("")) {
                query = em.createQuery("select z from Zona_Plantas z", Zona_Plantas.class);
            } else {
                query = em.createQuery("select z from Zona_Plantas z where z." 
                        + field.toLowerCase() + " like '%" + crit + "%'", Zona_Plantas.class);
            }
            results = query.getResultList();
            System.out.println("Objetos encontrados: " + results.size());
            
// Close the database connection:
        em.close();
        emf.close();
        return results;
    }
     
    public TableModel listToTableModel(List<Zona_Plantas> rs) {
        Vector<String> columnNames = new Vector<>();
        Vector<Vector<Object>> rows = new Vector<>();

        // Nombres de columnas para "Empleado"
            columnNames.addElement("id_Zona_Plantas");
            columnNames.addElement("temperatura");
            columnNames.addElement("humedad");
            columnNames.addElement("Fecha de Registro");
 

            // Iterar sobre la lista de empleados
            for (Zona_Plantas zonpla : rs) {
                Vector<Object> newRow = new Vector<>();
                newRow.addElement(zonpla.getId_Zona_Plantas());
                newRow.addElement(zonpla.getZonpla_temperatura());
                newRow.addElement(zonpla.getZonpla_humedad());
                newRow.addElement(zonpla.getZonpla_FechaRegistro());

                rows.addElement(newRow);
            }
        // Devuelve el DefaultTableModel con los datos
        return new DefaultTableModel(rows, columnNames);
        }
       
}
