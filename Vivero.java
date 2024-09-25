class Vivero{
    (extent viveros key viv_nombre)
    attribute String viv_nombre;
    attribute Direccion viv_direccion;
    attribute String viv_telefono;
    //relaciones
    relationship Empleado viv_emp
        inverse Empleado::emp_viv;
    relationship set<Zona> viv_zon
        inverse Zona::zon_viv;
    //operaciones
    void formViv_emp(Empleado empleado);
    void dropViv_emp(Empleado empleado);
    void formViv_zon(Zona zona);
    void dropViv_zon(Zona zona);
}

class Empleado{
    (extent empleados key emp_ine)
    attribute String emp_ine;
    attribute String emp_nombre;
    attribute String emp_telefono;   

    relationship Vivero emp_viv
        inverse Vivero::viv_emp;
    relationship set<Lista_Empleados_Zona> emp_lis
        inverse Lista_Empleados_Zona::lis_emp;

    
    void formEmp_viv(Vivero vivero);
    void dropEmp_viv(Vivero vivero);
    void formLis_emp(Lista_Empleados_Zona listaez);
    void dropLis_emp(Lista_Empleados_Zona listaez);
}

class Zona{
    (extent zonas key zon_nombre)
    attribute String zon_nombre;
    attribute String zon_tipo;
    
    relationship set<Lista_Empleados_Zona> zon_lisemp
        inverse Lista_Empleados_Zona::lis_zon;

    relationship Vivero zon_viv
        inverse Vivero::viv_zon;
    
    relationship set<Inventario> zon_inv
        inverse Inventario::inv_zon;

    relationship set<Zona_Plantas> zon_zonpla
        inverse Zona_Plantas::zonpla_zon;

    void formZon_lisemp(Lista_Empleados_Zona listaez);
    void DropZon_lisemp(Lista_Empleados_Zona listaez);
    void formZon_viv(Vivero vivero);
    void dropZon_viv(Vivero vivero);
    void formZon_inventario(Inventario inventario);
    void dropZon_inventario(Inventario inventario);
    void formZon_zonpla(Zona_Plantas zonaplantas);
    void dropZon_zonpla(Zona_Plantas zonaplantas);
}

class Lista_Empleados_Zona{
    // (extent listasEmp key )
    attribute Date lez_fechaHoraInicio;
    attribute Date lez_fechaHoraFin;

    relationship Empleado lis_emp
        inverse Empleado::emp_lis;
    
    relationship Zona lis_zon
        inverse Zona::zon_lisemp;
    
    void formLis_emp(Empleado empleado);
    void dropLis_emp(Empleado empleado);
    void formLis_zon(Zona zona);
    void dropLis_zon(Zona zona);

}

class Producto {
    (extent productos key pro_codigo)
    attribute String pro_codigo;
    attribute String pro_descripcion;
    attribute float pro_precio;
    attribute int pro_stock;


    relationship Planta pro_pla
        inverse Planta::pla_pro;

    relationship Inventario pro_inv
        inverse Inventario::inv_pro;

    void formPro_pla(Planta planta);
    void dropPro_pla(Planta planta);
    void formPro_inv(Inventario inventario);
    void dropPro_inv(Inventario inventario);

}

class Inventario {
    attribute int stock;
    relationship Zona inv_zon
        inverse Zona::zon_inv;
    relationship Producto inv_pro
        inverse Producto::pro_inv;

    void formInv_zon(Zona zona);
    void dropInv_zon(Zona zona);
    void formInv_pro(Producto producto);
    void dropInv_pro(Producto producto);
    
}
class Planta{
    (extent plantas key pla_nombre)
    attribute String pla_nombre;
    attribute String pla_clima;
    attribute String pla_cuidados;
    attribute String pla_humedad;
    attribute String pla_luz;

    relationship Producto pla_pro
        inverse Producto::pro_pla;

    void formPla_pro(Producto producto);
    void dropPla_pro(Producto producto);
}
class Zona_Plantas{
    attribute float temperatura;
    attribute String humedad;

    relationship Zona zonpla_zon
        inverse Zona::zon_zonpla;

    void formZonpla_zon(Zona zona);
    void dropZonpla_zon(Zona zona);
}

class Direccion{
    String estado;
    String municipio;
    String calle;
    String numExt;
    String numInt;
    String cp;
}