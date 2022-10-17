package modelo;

import fabrica.organizacion.Organizacion;
import fabrica.organizacion.OrganizacionAdministrativa;

public class OrganizacionModelo {
    public static Organizacion organizacion = new OrganizacionAdministrativa("ITO", "Alto", 20);
}
