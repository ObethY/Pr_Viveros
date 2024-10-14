/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

import entitys.Empleado;
import java.util.ArrayList;
import java.util.Iterator;
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
public class CRUDEmpleado {
    public void CreateEmpleado(Empleado ee) {
        Empleado e;
        String EmpIne = ee.getEmp_ine();
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        if(verificarIne(EmpIne)){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            e = ee;
            em.persist(e);
            em.getTransaction().commit();
    // Close the database connection:
            em.close();
            emf.close();
            System.out.println("Empleado registrado");
        }else{
            System.out.println("No se se realizo el registro");
        }
        
    }
    
    public List getEmpleado(String field, String crit){
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
            // Retrieve Proveedor objects from the database:
            TypedQuery<Empleado> query = null;
            List<Empleado> results = new ArrayList<Empleado>();
            if (crit.equals("")) {
                query = em.createQuery("select e from Empleado e", Empleado.class);
            } else {
                query = em.createQuery("select e from Empleado e where e." + field.toLowerCase() + " like '%" + crit + "%'", Empleado.class);
            }
            results = query.getResultList();
            System.out.println("Objetos encontrados: " + results.size());
            
// Close the database connection:
        em.close();
        emf.close();
        return results;
    }
    
    
    public TableModel listToTableModel(List<Empleado> rs) {
        Vector<String> columnNames = new Vector<>();
        Vector<Vector<Object>> rows = new Vector<>();

        // Nombres de columnas para "Empleado"
            columnNames.addElement("INE");
            columnNames.addElement("Nombre");
            columnNames.addElement("Teléfono");
 

            // Iterar sobre la lista de empleados
            for (Empleado e : rs) {
                Vector<Object> newRow = new Vector<>();
                newRow.addElement(e.getEmp_ine());
                newRow.addElement(e.getEmp_nombre());
                newRow.addElement(e.getEmp_telefono()); 

                rows.addElement(newRow);
            }
        // Devuelve el DefaultTableModel con los datos
        return new DefaultTableModel(rows, columnNames);
        }
    
    public boolean verificarIne(String ine){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
            // Retrieve Proveedor objects from the database:
            TypedQuery<Empleado> query = null;
            List<Empleado> results = new ArrayList<Empleado>();
            query = em.createQuery("select e from Empleado e where e.emp_ine = '"+ine+"'", Empleado.class);
            results = query.getResultList();
            System.out.println("Objetos encontrados: " + results);
            em.close();
            emf.close();
            if(results.isEmpty()){
                System.out.println("Sin Ine Encontrado");
                return true;
            }else{
                System.out.println("Encontro algo");
               return false;
            } 
    }
    
    public List<Empleado> getEmpleados() {
        // Abrir una conexión a la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();

        // Crear y ejecutar una consulta para obtener todos los empleados
        TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
        List<Empleado> empleados = query.getResultList();

        // Cerrar la conexión
        em.close();
        emf.close();

        return empleados;
    }
    
    }

