/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;


import entitys.Empleado;
import entitys.Inventario;
import entitys.Lista_Empleados_Zona;
import entitys.Planta;
import entitys.Producto;
import entitys.Vivero;
import entitys.Zona;
import entitys.Zona_Plantas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author obeth
 */
public class test {
     public static void main(String[] args) throws ParseException {
         //Crear BD
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/vivero.odb");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();

        
        //Empleados
        Empleado e1 = new Empleado("CADO031002HHGLZABA9", "Obeth", "7713185145");
        Empleado e2 = new Empleado("SRMZPT03090921M800", "Patricia", "7712926603");
        Empleado e3 = new Empleado("CASF884HHSL98AASD122", "Alejandro", "5512324321");
        Empleado e4 = new Empleado("DFCDSDFWEETTV5ASD234", "Obeth", "5512234526");
        Empleado e5 = new Empleado("DFGR2321324FAFD23", "Alan", "5523425432");
        Empleado e6 = new Empleado("WEF3442234QWER34", "Laura", "5587654321");
        Empleado e7 = new Empleado("DFWE432432DFAS342", "José", "5544332211");
        Empleado e8 = new Empleado("TYRU543435GHF654", "Jade", "5577665544");
        Empleado e9 = new Empleado("IUYT654324UIYT756", "Carlos", "5588996677");
        Empleado e10 = new Empleado("UJHT754435GVFS766", "Ana", "5533224455");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaini = null, fechafin = null;
        Date fechaini1 = null, fechafin1 = null;
        Date fechaini2 = null, fechafin2 = null;
        Date fechaini3 = null, fechafin3 = null;
        Date fechaini4 = null, fechafin4 = null;
        Date fechaini5 = null, fechafin5 = null;
        Date fechaini6 = null, fechafin6 = null;
        Date fechaini7 = null, fechafin7 = null;
        Date fechaini8 = null, fechafin8 = null;
        Date fechaini9 = null, fechafin9 = null;
        
        
        try {
            fechaini = dateFormat.parse("2024-12-12");
            fechafin = dateFormat.parse("2024-15-12");
            fechaini1 = dateFormat.parse("2024-23-12");
            fechafin1 = dateFormat.parse("2025-11-1");
            fechaini2 = dateFormat.parse("2024-10-12");
            fechafin2 = dateFormat.parse("2024-11-12");
            fechaini3 = dateFormat.parse("2024-1-12");
            fechafin3 = dateFormat.parse("2024-2-12");
            fechaini4 = dateFormat.parse("2024-03-03");
            fechafin4 = dateFormat.parse("2024-03-10");
            fechaini5 = dateFormat.parse("2024-04-05");
            fechafin5 = dateFormat.parse("2024-04-12");
            fechaini6 = dateFormat.parse("2024-05-06");
            fechafin6 = dateFormat.parse("2024-05-13");
            fechaini7 = dateFormat.parse("2024-06-07");
            fechafin7 = dateFormat.parse("2024-06-14");
            fechaini8 = dateFormat.parse("2024-07-08");
            fechafin8 = dateFormat.parse("2024-07-15");
            fechaini9 = dateFormat.parse("2024-08-09");
            fechafin9 = dateFormat.parse("2024-08-16");                       
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        //Lista de Empleados
//        Lista_Empleados_Zona l1 = new Lista_Empleados_Zona(1, fechaini, fechafin);
//        Lista_Empleados_Zona l2 = new Lista_Empleados_Zona(2, fechaini1, fechafin1);
//        Lista_Empleados_Zona l3 = new Lista_Empleados_Zona(3, fechaini2, fechafin2);
//        Lista_Empleados_Zona l4 = new Lista_Empleados_Zona(4, fechaini3, fechafin3);
//        Lista_Empleados_Zona l5 = new Lista_Empleados_Zona(5, fechaini4, fechafin4);
//        Lista_Empleados_Zona l6 = new Lista_Empleados_Zona(6, fechaini5, fechafin5);
//        Lista_Empleados_Zona l7 = new Lista_Empleados_Zona(7, fechaini6, fechafin6);
//        Lista_Empleados_Zona l8 = new Lista_Empleados_Zona(8, fechaini7, fechafin7);
        
//        // Productos
//        Producto p1 = new Producto("A01", "Maceta de plástico pequeña roja", "Accesorios", 24);
//        Producto p2 = new Producto("A02", "Sustrato orgánico 5 kg", "Jardinería", 80);
//        Producto p3 = new Producto("A03", "Abono granulado universal 1 kg", "Jardinería", 45);
//        Producto p4 = new Producto("A04", "Maceta cerámica mediana blanca", "Accesorios", 120);
//        Producto p5 = new Producto("A05", "Kit de herramientas para jardinería", "Jardinería", 150);
//
//        // Productos plantas
//        Producto p6 = new Producto("A06", "Planta suculenta en maceta", "Planta", 35);
//        Producto p7 = new Producto("A07", "Planta de lavanda en maceta", "Planta", 60);
//        Producto p8 = new Producto("A08", "Cactus pequeño en maceta", "Planta", 40);
//        Producto p9 = new Producto("A09", "Árbol de limón joven", "Planta", 250);
//        Producto p10 = new Producto("A10", "Planta de romero en maceta", "Planta", 55);
//        Producto p11 = new Producto("A11", "Planta de menta en maceta", "Planta", 30);
//        Producto p12 = new Producto("A12", "Helecho de interior en maceta", "Planta", 45);
//        Producto p13 = new Producto("A13", "Bonsái de pino", "Planta", 200);
//        Producto p14 = new Producto("A14", "Orquídea en maceta pequeña", "Planta", 60);
//        Producto p15 = new Producto("A15", "Planta de albahaca en maceta", "Planta", 35);
//        Producto p16 = new Producto("A16", "Árbol de manzana joven", "Planta", 300);
//        Producto p17 = new Producto("A17", "Planta de lavanda inglesa en maceta", "Planta", 70);
//        Producto p18 = new Producto("A18", "Crisantemo en maceta grande", "Planta", 80);
//        Producto p19 = new Producto("A19", "Bambú de la suerte", "Planta", 25);
//        Producto p20 = new Producto("A20", "Planta de geranio en maceta", "Planta", 55);
        
        // Plantas
        Planta pa1 = new Planta("Suculenta", "Árido", "Riego ocasional", "Baja", "Luz indirecta");
        Planta pa2 = new Planta("Lavanda", "Templado", "Riego moderado", "Media", "Pleno sol");
        Planta pa3 = new Planta("Cactus", "Desértico", "Riego muy escaso", "Baja", "Sol directo");
        Planta pa4 = new Planta("Árbol de limón", "Tropical", "Riego frecuente", "Alta", "Pleno sol");
        Planta pa5 = new Planta("Romero", "Mediterráneo", "Riego moderado", "Media", "Luz directa");
        Planta pa6 = new Planta("Menta", "Frío", "Riego frecuente", "Media", "Sombra parcial");
        Planta pa7 = new Planta("Helecho", "Templado", "Riego moderado", "Baja", "Sombra completa");
        Planta pa8 = new Planta("Bonsái de pino", "Frío", "Riego ocasional", "Alta", "Luz directa");
        Planta pa9 = new Planta("Orquídea", "Tropical", "Riego moderado", "Media", "Luz indirecta");
        Planta pa10 = new Planta("Albahaca", "Mediterráneo", "Riego frecuente", "Media", "Pleno sol");
        Planta pa11 = new Planta("Árbol de manzana", "Templado", "Riego moderado", "Alta", "Pleno sol");
        Planta pa12 = new Planta("Lavanda inglesa", "Frío", "Riego moderado", "Media", "Pleno sol");
        Planta pa13 = new Planta("Crisantemo", "Templado", "Riego moderado", "Baja", "Luz indirecta");
        Planta pa14 = new Planta("Bambú de la suerte", "Tropical", "Riego frecuente", "Baja", "Luz indirecta");
        Planta pa15 = new Planta("Geranio", "Mediterráneo", "Riego frecuente", "Media", "Pleno sol");
        
        //Vivero
        Vivero v1 = new Vivero("V001", "7711234567", "Av. Revolución", "123", "San Ángel", "Ciudad de México", "CDMX", "01000");
        Vivero v2 = new Vivero("V002", "7719876543", "Calle 5 de Febrero", "45", "Centro", "Monterrey", "Nuevo León", "64000");
        Vivero v3 = new Vivero("V003", "7715554321", "Av. Hidalgo", "567", "Americana", "Guadalajara", "Jalisco", "44100");
        Vivero v4 = new Vivero("V004", "7713214567", "Calle 16 de Septiembre", "101", "El Carmen", "Puebla", "Puebla", "72000");
        Vivero v5 = new Vivero("V005", "7717654321", "Av. Juárez", "789", "Centro", "Mérida", "Yucatán", "97000");
        Vivero v6 = new Vivero("V006", "7711112233", "Calle Insurgentes", "233", "Condesa", "Ciudad de México", "CDMX", "01100");
        Vivero v7 = new Vivero("V007", "7712223344", "Calle Morelos", "567", "Santa Margarita", "Zapopan", "Jalisco", "45100");
        Vivero v8 = new Vivero("V008", "7713334455", "Calle Allende", "123", "Centro", "San Luis Potosí", "San Luis Potosí", "78000");
        Vivero v9 = new Vivero("V009", "7714445566", "Av. Tecnológico", "234", "Centro Sur", "Querétaro", "Querétaro", "76000");
        Vivero v10 = new Vivero("V010", "7715556677", "Calle Independencia", "789", "Jalatlaco", "Oaxaca", "Oaxaca", "68000");
        
        //Zona que almacenan plantas
        Zona z1 = new Zona("Z01", "Zona Exterior de Regadío", "Área al aire libre para cultivo con riego adecuado.", 200);
        Zona z2 = new Zona("Z02", "Zona Interior Climatizada", "Espacio cerrado con control de temperatura y humedad.", 150);
        Zona z3 = new Zona("Z03", "Invernadero", "Estructura que proporciona un ambiente controlado para el crecimiento de plantas.", 300);
        Zona z4 = new Zona("Z04", "Zona de Exposición", "Área destinada a exhibir plantas y productos en condiciones adecuadas.", 100);
        Zona z5 = new Zona("Z05", "Zona de Cultivo Hidropónico", "Zona especializada en el cultivo de plantas sin suelo, utilizando soluciones nutritivas.", 250);
        
        //Zonas 
        Zona z6 = new Zona("Z06", "Zona de Caja", "Área designada para el cobro y atención al cliente.", 50);
        Zona z7 = new Zona("Z07", "Almacén de Herramientas", "Espacio para guardar herramientas y equipos de jardinería.", 80);
        Zona z8 = new Zona("Z08", "Oficina Administrativa", "Zona dedicada a la gestión y administración del vivero.", 60);
        Zona z9 = new Zona("Z09", "Zona de Carga y Descarga", "Área utilizada para la logística de productos, no para plantas.", 100);
        Zona z10 = new Zona("Z10", "Sala de Capacitación", "Espacio para la formación del personal, sin almacenamiento de plantas.", 40);
        
        //Zona-Planta
        
        // Zona Exterior de Regadío
//        Zona_Plantas zp1a = new Zona_Plantas(1, "Alta",  25.0f, dateFormat.parse("2024-01-01"));
//        Zona_Plantas zp1b = new Zona_Plantas(2, dateFormat.parse("2024-02-01"), 26.0f, "Alta");
//        Zona_Plantas zp1c = new Zona_Plantas(3, dateFormat.parse("2024-03-01"), 24.5f, "Alta");
//        Zona_Plantas zp1d = new Zona_Plantas(4, dateFormat.parse("2024-04-01"), 27.0f, "Alta");
//        Zona_Plantas zp1e = new Zona_Plantas(5, dateFormat.parse("2024-05-01"), 28.0f, "Alta");
//        Zona_Plantas zp1f = new Zona_Plantas(6, dateFormat.parse("2024-06-01"), 26.5f, "Alta");
//
//        // Zona Interior Climatizada
//        Zona_Plantas zp2a = new Zona_Plantas(7, dateFormat.parse("2024-07-05"), 22.0f, "Media");
//        Zona_Plantas zp2b = new Zona_Plantas(8, dateFormat.parse("2024-08-05"), 23.0f, "Media");
//        Zona_Plantas zp2c = new Zona_Plantas(9, dateFormat.parse("2024-08-05"), 21.5f, "Media");
//        Zona_Plantas zp2d = new Zona_Plantas(10, dateFormat.parse("2024-09-05"), 22.5f, "Media");
//        Zona_Plantas zp2e = new Zona_Plantas(11, dateFormat.parse("2024-09-05"), 23.0f, "Media");
//        Zona_Plantas zp2f = new Zona_Plantas(12, dateFormat.parse("2024-09-05"), 22.8f, "Media");
//
//        // Invernadero
//        Zona_Plantas zp3a = new Zona_Plantas(13, dateFormat.parse("2024-01-10"), 20.0f, "Controlada");
//        Zona_Plantas zp3b = new Zona_Plantas(14, dateFormat.parse("2024-02-10"), 21.0f, "Controlada");
//        Zona_Plantas zp3c = new Zona_Plantas(15, dateFormat.parse("2024-03-10"), 19.5f, "Controlada");
//        Zona_Plantas zp3d = new Zona_Plantas(16, dateFormat.parse("2024-04-10"), 20.5f, "Controlada");
//        Zona_Plantas zp3e = new Zona_Plantas(17, dateFormat.parse("2024-05-10"), 21.0f, "Controlada");
//        Zona_Plantas zp3f = new Zona_Plantas(18, dateFormat.parse("2024-06-10"), 20.8f, "Controlada");
//
//        // Zona de Exposición
//        Zona_Plantas zp4a = new Zona_Plantas(19, dateFormat.parse("2024-01-15"), 24.0f, "Media");
//        Zona_Plantas zp4b = new Zona_Plantas(20, dateFormat.parse("2024-02-15"), 25.0f, "Media");
//        Zona_Plantas zp4c = new Zona_Plantas(21, dateFormat.parse("2024-03-15"), 23.5f, "Media");
//        Zona_Plantas zp4d = new Zona_Plantas(22, dateFormat.parse("2024-04-15"), 24.5f, "Media");
//        Zona_Plantas zp4e = new Zona_Plantas(23, dateFormat.parse("2024-05-15"), 25.0f, "Media");
//        Zona_Plantas zp4f = new Zona_Plantas(24, dateFormat.parse("2024-06-15"), 24.8f, "Media");
//
//        // Zona de Cultivo Hidropónico
//        Zona_Plantas zp5a = new Zona_Plantas(25, dateFormat.parse("2024-01-20"), 23.0f, "Alta");
//        Zona_Plantas zp5b = new Zona_Plantas(26, dateFormat.parse("2024-02-20"), 24.0f, "Alta");
//        Zona_Plantas zp5c = new Zona_Plantas(27, dateFormat.parse("2024-03-20"), 22.5f, "Alta");
//        Zona_Plantas zp5d = new Zona_Plantas(28, dateFormat.parse("2024-04-20"), 23.5f, "Alta");
//        Zona_Plantas zp5e = new Zona_Plantas(29, dateFormat.parse("2024-05-20"), 24.0f, "Alta");
//        Zona_Plantas zp5f = new Zona_Plantas(30, dateFormat.parse("2024-06-20"), 23.8f, "Alta");

        
        //Inventario
        Inventario i1 = new Inventario("INV001", 150);
        Inventario i2 = new Inventario("INV002", 80);
        Inventario i3 = new Inventario("INV003", 120);
        Inventario i4 = new Inventario("INV004", 40);
        Inventario i5 = new Inventario("INV005", 30);
        Inventario i6 = new Inventario("INV006", 80);
        Inventario i7 = new Inventario("INV007", 50);
        Inventario i8 = new Inventario("INV008", 100);
        Inventario i9 = new Inventario("INV009", 15);
        Inventario i10 = new Inventario("INV010", 70);
        Inventario i11 = new Inventario("INV011", 70);
        Inventario i12 = new Inventario("INV012", 123);
        Inventario i13 = new Inventario("INV012", 124);
        Inventario i14 = new Inventario("INV012", 125);
        
        
        
        /* ---------------------------------------------------------------------------------*/       
           
        //relacion Empleado-->ListaEmpleados      
//        e1.formEmp_lis(l1);
//        e2.formEmp_lis(l2);
//        e3.formEmp_lis(l3);
//        e4.formEmp_lis(l4);
//        e5.formEmp_lis(l5);
//        e6.formEmp_lis(l6);
//        e7.formEmp_lis(l7);
//        e8.formEmp_lis(l8);
//                
//        //relacion ListaEmpleados-->Empleado
//        l1.formLis_emp(e1);
//        l2.formLis_emp(e2);
//        l3.formLis_emp(e3);
//        l4.formLis_emp(e4);
//        l5.formLis_emp(e5);
//        l6.formLis_emp(e6);
//        l7.formLis_emp(e7);
//        l8.formLis_emp(e8);
        
        //relacion listaemp --> zona
        
        
        
//        //Relacion Productos --> Plantas
//        p6.formPro_pla(pa1);
//        p7.formPro_pla(pa2);
//        p8.formPro_pla(pa3);
//        p9.formPro_pla(pa4);
//        p10.formPro_pla(pa5);
//        p11.formPro_pla(pa6);
//        p12.formPro_pla(pa7);
//        p13.formPro_pla(pa8);
//        p14.formPro_pla(pa9);
//        p15.formPro_pla(pa10);
//        p16.formPro_pla(pa11);
//        p17.formPro_pla(pa12);
//        p18.formPro_pla(pa13);
//        p19.formPro_pla(pa14);
//        p20.formPro_pla(pa15);
//        
//        //Relacion plantas --> productos       
//        pa1.formPla_pro(p6);
//        pa2.formPla_pro(p7);
//        pa3.formPla_pro(p8);
//        pa4.formPla_pro(p9);
//        pa5.formPla_pro(p10);
//        pa6.formPla_pro(p11);
//        pa7.formPla_pro(p12);
//        pa8.formPla_pro(p13);
//        pa9.formPla_pro(p14);
//        pa10.formPla_pro(p15);
//        pa11.formPla_pro(p16);
//        pa12.formPla_pro(p17);
//        pa13.formPla_pro(p18);
//        pa14.formPla_pro(p19);
//        pa15.formPla_pro(p20);        
        
        //relacion Vivero --> Empleado
        v1.formViv_emp(e1);       
        v2.formViv_emp(e6);
        v3.formViv_emp(e1);
        v4.formViv_emp(e9);
        
        //relacion empleado --> vivero
        e1.formEmp_viv(v1);
        e6.formEmp_viv(v2);
        e1.formEmp_viv(v3);
        e9.formEmp_viv(v4);
        e3.formEmp_viv(v1);
        e4.formEmp_viv(v1);
        e5.formEmp_viv(v1);
        e7.formEmp_viv(v1);
        e10.formEmp_viv(v1);
        
        //relacion vivero --> zona
        v1.formViv_zon(z6);
        v1.formViv_zon(z7);
        v1.formViv_zon(z1);
        v1.formViv_zon(z2);
        v1.formViv_zon(z3);
        v1.formViv_zon(z4);
        v1.formViv_zon(z5);
        
        v2.formViv_zon(z1);
        v2.formViv_zon(z8);
        v2.formViv_zon(z9);
        v2.formViv_zon(z10);
        
        //relacion zona --> vivero
        
        z1.formZon_viv(v1);
        z2.formZon_viv(v1);
        z3.formZon_viv(v1);
        z4.formZon_viv(v1);
        z5.formZon_viv(v1);
        z6.formZon_viv(v1);
        z7.formZon_viv(v1);
        
        z8.formZon_viv(v2);
        //z1.formZon_viv(v2);
        z9.formZon_viv(v2);
        z10.formZon_viv(v2);
       
//        //relacion inventario --> producto
//        i1.formInv_pro(p1);
//        i2.formInv_pro(p2);
//        i3.formInv_pro(p3);
//        i4.formInv_pro(p4);
//        
//        i5.formInv_pro(p5);
//        i6.formInv_pro(p6);
//        i11.formInv_pro(p6);
//        i7.formInv_pro(p7);
//        i8.formInv_pro(p8);
//        i9.formInv_pro(p9);
//        i10.formInv_pro(p10);
//        
//        i12.formInv_pro(p11);
//        i13.formInv_pro(p13);
//        i14.formInv_pro(p17);
//        
//        //relacion producto --> inventario
//        p1.formPro_inv(i1);
//        p2.formPro_inv(i2);
//        p3.formPro_inv(i3);
//        p4.formPro_inv(i4);
//        
//        p5.formPro_inv(i5);
//        p6.formPro_inv(i6);
//        p6.formPro_inv(i11);
//        p7.formPro_inv(i7);
//        p8.formPro_inv(i8);
//        p9.formPro_inv(i9);
//        p10.formPro_inv(i10);
//        
//        p11.formPro_inv(i12);
//        p13.formPro_inv(i13);
//        p17.formPro_inv(i14);
        
        //relacion inventario --> zona
        i1.formInv_zon(z6);
        i2.formInv_zon(z6);
        i3.formInv_zon(z7);
        i4.formInv_zon(z7);
        
        i5.formInv_zon(z1);
        i6.formInv_zon(z1);
        i7.formInv_zon(z1);
        i8.formInv_zon(z1);
        i9.formInv_zon(z1);
        i10.formInv_zon(z1);
        i11.formInv_zon(z1);
        i12.formInv_zon(z1);
        i13.formInv_zon(z1);
        i14.formInv_zon(z1);
        
        i5.formInv_zon(z2);
        i6.formInv_zon(z2);
        i7.formInv_zon(z2);
        i8.formInv_zon(z2);
        
        i5.formInv_zon(z3);
        i6.formInv_zon(z3);
        i7.formInv_zon(z3);
        i8.formInv_zon(z3);
        
        i5.formInv_zon(z4);
        i6.formInv_zon(z4);
        i7.formInv_zon(z4);
        i8.formInv_zon(z4);
        
        i5.formInv_zon(z5);
        i6.formInv_zon(z5);
        i7.formInv_zon(z5);
        i8.formInv_zon(z5);
        i9.formInv_zon(z5);
        i10.formInv_zon(z5);
        
        //relacion zona --> inventario
        z6.formZon_inv(i1);
        z6.formZon_inv(i2);
        z7.formZon_inv(i3);
        z7.formZon_inv(i4);
        z1.formZon_inv(i5);
        z1.formZon_inv(i6);
        z1.formZon_inv(i7);
        z1.formZon_inv(i8);
        z1.formZon_inv(i9);
        z1.formZon_inv(i10);
        z1.formZon_inv(i11);
        z1.formZon_inv(i12);
        z1.formZon_inv(i13);
        z1.formZon_inv(i14);
        z2.formZon_inv(i5);
        z2.formZon_inv(i6);
        z2.formZon_inv(i7);
        z2.formZon_inv(i8);
        z3.formZon_inv(i5);
        z3.formZon_inv(i6);
        z3.formZon_inv(i7);
        z3.formZon_inv(i8);
        z4.formZon_inv(i5);
        z4.formZon_inv(i6);
        z4.formZon_inv(i7);
        z4.formZon_inv(i8);
        z5.formZon_inv(i5);
        z5.formZon_inv(i6);
        z5.formZon_inv(i7);
        z5.formZon_inv(i8);
        z5.formZon_inv(i9);
        z5.formZon_inv(i10);
        //relacion zona --> zona_planta
//        z1.formZon_zonpla(zp1a);
//        z1.formZon_zonpla(zp1b);
//        z1.formZon_zonpla(zp1c);
//        z1.formZon_zonpla(zp1d);
//        z1.formZon_zonpla(zp1e);
//        z1.formZon_zonpla(zp1f);
//        
//        z2.formZon_zonpla(zp2a);
//        z2.formZon_zonpla(zp2b);
//        z2.formZon_zonpla(zp2c);
//        z2.formZon_zonpla(zp2d);
//        z2.formZon_zonpla(zp2e);
//        z2.formZon_zonpla(zp2f);
//        
//        z3.formZon_zonpla(zp3a);
//        z3.formZon_zonpla(zp3b);
//        z3.formZon_zonpla(zp3c);
//        z3.formZon_zonpla(zp3d);
//        
//        z4.formZon_zonpla(zp4a);
//        z4.formZon_zonpla(zp4b);
//        
//        z5.formZon_zonpla(zp5a);
//        z5.formZon_zonpla(zp5b);
//        z5.formZon_zonpla(zp5c);
//        z5.formZon_zonpla(zp5d);
//        z5.formZon_zonpla(zp5e);
//        
//        //relacion zona_pla --> zona 
//        zp1a.formZonpla_zon(z1);
//        zp1b.formZonpla_zon(z1);
//        zp1c.formZonpla_zon(z1);
//        zp1d.formZonpla_zon(z1);
//        zp1e.formZonpla_zon(z1);
//        zp1f.formZonpla_zon(z1);
//        
//        zp2a.formZonpla_zon(z2);
//        zp2b.formZonpla_zon(z2);
//        zp2c.formZonpla_zon(z2);
//        zp2d.formZonpla_zon(z2);
//        zp2e.formZonpla_zon(z2);
//        zp2f.formZonpla_zon(z2);
//        
//        zp3a.formZonpla_zon(z3);
//        zp3b.formZonpla_zon(z3);
//        zp3c.formZonpla_zon(z3);
//        zp3d.formZonpla_zon(z3);
//        
//        zp4a.formZonpla_zon(z4);
//        zp4b.formZonpla_zon(z4);
//        
//        zp5a.formZonpla_zon(z5);
//        zp5b.formZonpla_zon(z5);
//        zp5c.formZonpla_zon(z5);
//        zp5d.formZonpla_zon(z5);
//        zp5e.formZonpla_zon(z5);

        //relacion zona --> lista enpleados
//        z1.formZon_lis(l1);
//        z1.formZon_lis(l2);
//        z1.formZon_lis(l3);
//        z1.formZon_lis(l4);
//        z1.formZon_lis(l5);
//        
//        z5.formZon_lis(l6);
//        z5.formZon_lis(l7);      
//        z5.formZon_lis(l8);   
//        
//        //relacion lista --> zona
//        l1.formLis_zon(z1);
//        l2.formLis_zon(z1);
//        l3.formLis_zon(z1);
//        l4.formLis_zon(z1);
//        l5.formLis_zon(z1);
//        l6.formLis_zon(z5);
//        l7.formLis_zon(z5);
//        l8.formLis_zon(z5);
        
//        //persistir objetos
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//        em.persist(p4);
//        em.persist(p5);
//        em.persist(p6);
//        em.persist(p7);
//        em.persist(p8);
//        em.persist(p9);
//        em.persist(p10);
//        em.persist(p11);
//        em.persist(p12);
//        em.persist(p13);
//        em.persist(p14);
//        em.persist(p15);
//        em.persist(p16);
//        em.persist(p17);
//        em.persist(p18);
//        em.persist(p19);
//        em.persist(p20);
        
        em.persist(pa1);
        em.persist(pa2);
        em.persist(pa3);
        em.persist(pa4);
        em.persist(pa5);
        em.persist(pa6);
        em.persist(pa7);
        em.persist(pa8);
        em.persist(pa9);
        em.persist(pa10);
        em.persist(pa11);
        em.persist(pa12);
        em.persist(pa13);
        em.persist(pa14);
        em.persist(pa15);
        
        //persistir objetos
        
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);       
        em.persist(e5);
        em.persist(e6);
        em.persist(e7);
        em.persist(e8);
        em.persist(e9);
        em.persist(e10);  
        
//        em.persist(l1);
//        em.persist(l2);
//        em.persist(l3);
//        em.persist(l4);
//        em.persist(l5);
//        em.persist(l6);
//        em.persist(l7);
//        em.persist(l8);
//        
        em.persist(v1);
        em.persist(v2);
        em.persist(v3);
        em.persist(v4);
        em.persist(v5);
        em.persist(v6);
        em.persist(v7);
        em.persist(v8);
        em.persist(v9);
        em.persist(v10);
        
        //Objetos zona       
        
        em.persist(z1);
        em.persist(z2);
        em.persist(z3);
        em.persist(z4);
        em.persist(z5);
        em.persist(z6);
        em.persist(z7);
        em.persist(z8);
        
//        //Objetos zona-planta
//        em.persist(zp1a);
//        em.persist(zp1b);
//        em.persist(zp1c);
//        em.persist(zp1d);
//        em.persist(zp1e);
//        em.persist(zp1f);
//        
//        em.persist(zp2a);
//        em.persist(zp2b);
//        em.persist(zp2c);
//        em.persist(zp2d);
//        em.persist(zp2e);
//        em.persist(zp2f);
//        
//        em.persist(zp3a);
//        em.persist(zp3b);
//        em.persist(zp3c);
//        em.persist(zp3d);
//        em.persist(zp3e);
//        em.persist(zp3f);
//        
//        em.persist(zp4a);
//        em.persist(zp4b);
//        em.persist(zp4c);
//        em.persist(zp4d);
//        em.persist(zp4e);
//        em.persist(zp4f);
//        
//        em.persist(zp5a);
//        em.persist(zp5b);
//        em.persist(zp5c);
//        em.persist(zp5d);
//        em.persist(zp5e);
//        em.persist(zp5f);
        
        
        //Objetos inventario 
        em.persist(i1);
        em.persist(i2);
        em.persist(i3);
        em.persist(i4);
        em.persist(i5);
        em.persist(i6);
        em.persist(i7);
        em.persist(i8);
        em.persist(i9);
        em.persist(i10);
        em.persist(i11);
        em.persist(i12);
        em.persist(i13);
        em.persist(i14);
        
        em.getTransaction().commit();
        // Close the database connection:
        em.close();
        emf.close();
    }
}
