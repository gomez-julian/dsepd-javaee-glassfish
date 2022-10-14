package cliente;

import fabrica.organizacion.Organizacion;
import fabrica.organizacion.OrganizacionAcademica;
import fabrica.trabajador.Trabajador;

public class OrganizacionPrueba {
    public static void main(String[] args) {
        Organizacion organizacion = new OrganizacionAcademica("ITO", "Superior", 5);

        Trabajador trabajador = organizacion.getTrabajador();
        trabajador.registrarDatos("Docente de sistemas");
        trabajador.setNombre("Julián Gómez");

        System.out.println(trabajador);

        Trabajador trabajador2 = organizacion.getTrabajador();
        trabajador2.registrarDatos("Docente de química");
        trabajador2.setNombre("Enrique Suárez");

        System.out.println(trabajador2);
    }
}
