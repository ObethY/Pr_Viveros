/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;
import entitys.Empleado;
import entitys.Lista_Empleados_Zona;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import entitys.Zona;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.persistence.TypedQuery;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author obeth
 */
public class CRUDLista_Empleados_Zona {

    public boolean CreateListaEmpleadoZona(Lista_Empleados_Zona l1, String zona,String empleado) {
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
            Empleado emp = em.find(Empleado.class,empleado );
            if (emp == null) {
                System.out.println("Empleado no encontrado modifique la INE: " + empleado);
                return false;  // Retorna false si el vivero no se encuentra
            }
            // Crear la nueva lista y se relaciona con la zona y con el empleado
            l1.formLis_emp(emp);  // Relaciona la lista con el empleado
            emp.formEmp_lis(l1);  // Relaciona el empleado con la zona 

            l1.formLis_zon(zo);//se relaciona con la lista y con la zona
            zo.formZon_lis(l1);//se relacion con la zona con el vivero 
            // Persistir solo la nueva Zona
            
            em.persist(l1);
            em.getTransaction().commit();
            result = true;  // Operación exitosa

            System.out.println("Lista Registrada y relacionada con: " + emp.getEmp_ine()+" , "+zo.getZon_nombre());
        } catch (Exception e) {
            // Si ocurre algún error, hacemos rollback y manejamos la excepción
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar la Lista: " + e.getMessage());
            result = false;  // Ocurrió un error
        } finally {
            em.close();
            emf.close();
        }
        return result;  // Retorna true si la operación fue exitosa, false en caso de fallo
    }
    
    public TableModel listToTableModel(List<Lista_Empleados_Zona> rs) {
        Vector<String> columnNames = new Vector<>();
        Vector<Vector<Object>> rows = new Vector<>();

        // Nombres de columnas para "Empleado"
            columnNames.addElement("id_lista");
            columnNames.addElement("lis_fecha_inicio");
            columnNames.addElement("lis_fecha_fin");
 

            // Iterar sobre la lista de empleados
            for (Lista_Empleados_Zona l1 : rs) {
                Vector<Object> newRow = new Vector<>();
                newRow.addElement(l1.getId_Lista());
                newRow.addElement(l1.getLis_fecha_Final());
                newRow.addElement(l1.getLis_fecha_Inicio()); 

                rows.addElement(newRow);
            }
        // Devuelve el DefaultTableModel con los datos
        return new DefaultTableModel(rows, columnNames);
        }
    
    
    public List getListaEmpleadosZona(String field, String crit){
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
            // Retrieve Proveedor objects from the database:
            TypedQuery<Lista_Empleados_Zona> query = null;
            List<Lista_Empleados_Zona> results = new ArrayList<Lista_Empleados_Zona>();
            if (crit.equals("")) {
                query = em.createQuery("select l from Lista_Empleados_Zona l", Lista_Empleados_Zona.class);
            } else {
                query = em.createQuery("select l from Lista_Empleados_Zona l where l." 
                        + field.toLowerCase() + " like '%" + crit + "%'", Lista_Empleados_Zona.class);
            }
            results = query.getResultList();
            System.out.println("Objetos encontrados: " + results.size());
            
// Close the database connection:
        em.close();
        emf.close();
        return results;
    }
    
}
