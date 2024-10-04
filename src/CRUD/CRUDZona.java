/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;


import entitys.Vivero;
import entitys.Zona;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author obeth
 */
public class CRUDZona {
    
    public boolean CreateZona(Zona zz, String viveroId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
        boolean result = false;

        try {
            em.getTransaction().begin();

            // Buscar el Vivero existente por su ID
            Vivero vi = em.find(Vivero.class, viveroId);
            if (vi == null) {
                System.out.println("Vivero no encontrado con el ID: " + viveroId);
                return false;  // Retorna false si el vivero no se encuentra
            }

            // Crear la nueva Zona y establecer la relación
            zz.formZon_viv(vi);  // Relaciona la Zona con el Vivero
            vi.formViv_zon(zz);  // Relaciona el Vivero con la nueva Zona

            // Persistir solo la nueva Zona
            em.persist(zz);
            em.getTransaction().commit();
            result = true;  // Operación exitosa

            System.out.println("Zona registrada y relacionada con Vivero ID: " + viveroId);
        } catch (Exception e) {
            // Si ocurre algún error, hacemos rollback y manejamos la excepción
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar la zona: " + e.getMessage());
            result = false;  // Ocurrió un error
        } finally {
            em.close();
            emf.close();
        }
        return result;  // Retorna true si la operación fue exitosa, false en caso de fallo
    }
    
    public TableModel listToTableModel(List<Zona> rs) {
        Vector<String> columnNames = new Vector<>();
        Vector<Vector<Object>> rows = new Vector<>();

        // Nombres de columnas para "Empleado"
            columnNames.addElement("Nombre");
            columnNames.addElement("Tipo");
            columnNames.addElement("Superficie");
 

            // Iterar sobre la lista de empleados
            for (Zona e : rs) {
                Vector<Object> newRow = new Vector<>();
                newRow.addElement(e.getZon_nombre());
                newRow.addElement(e.getZon_tipo());
                newRow.addElement(e.getZon_superficie()); 

                rows.addElement(newRow);
            }
        // Devuelve el DefaultTableModel con los datos
        return new DefaultTableModel(rows, columnNames);
        }
    
    public List<Zona> getZonaPorVivero(String codigoVivero) {
        // Open a database connection (create a new database if it doesn't exist yet)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();

        // Retrieve Zona objects where the Vivero's code matches the specified one
        TypedQuery<Zona> query = em.createQuery(
            "SELECT z FROM Zona z JOIN z.zon_viv v WHERE v.codigo = :codigoVivero", 
            Zona.class);
        query.setParameter("codigoVivero", codigoVivero);

        List<Zona> results = query.getResultList();
        System.out.println("Zonas encontradas: " + results.size());

        // Close the database connection
        em.close();
        emf.close();

        return results;
    }

    
        public List getZona(String field, String crit){
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
            // Retrieve Proveedor objects from the database:
            TypedQuery<Zona> query = null;
            List<Zona> results = new ArrayList<Zona>();
            if (crit.equals("")) {
                query = em.createQuery("select e from Zona e", Zona.class);
            } else {
                query = em.createQuery("select e from Zona e where e." + field.toLowerCase() + " like '%" + crit + "%'", Zona.class);
            }
            results = query.getResultList();
            System.out.println("Objetos encontrados: " + results.size());
            
// Close the database connection:
        em.close();
        emf.close();
        return results;
    }
    
}
