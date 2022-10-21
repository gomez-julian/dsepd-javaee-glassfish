package modelo;

import fabrica.organizacion.Organizacion;
import fabrica.organizacion.OrganizacionAdministrativa;
import fabrica.trabajador.Trabajador;

public class OrganizacionModelo {
    public static Organizacion organizacion = getInstance();

    private static Organizacion getInstance(){
        Organizacion organizacion = new OrganizacionAdministrativa("ITO", "Alto", 20,2,2);
        String[] nombres = {"Julian", "Juan", "Ariel", "Diego", "Raul", "Manuel"};
        Trabajador trabajador;
        for(String nombre: nombres){
            trabajador = organizacion.getTrabajador();
            trabajador.registrarDatos(organizacion.getActvidades()[(int) (Math.random() * 4)]);
            trabajador.setNombre(nombre);
            trabajador.setSalario((int) (Math.random() * (450)) + 50);
        }
        return organizacion;
    }
}
