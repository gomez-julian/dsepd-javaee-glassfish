package fabrica.organizacion;

import fabrica.trabajador.Trabajador;
import fabrica.trabajador.TrabajadorAdministrativo;

public class OrganizacionAdministrativa extends Organizacion{

    public OrganizacionAdministrativa(String nombre, String nivel, int limiteTrabajadores) {
        super(nombre, nivel, limiteTrabajadores);
    }

    @Override
    public Trabajador getTrabajador() {
        if(this.trabajadores.size() >= this.limiteTrabajadores)
            throw new RuntimeException("Se ha intentado exceder el límite de trabajadores en" + this.nombre);
        Trabajador trabajador = new TrabajadorAdministrativo(Trabajador.generarId(), "Administrativo");
        this.trabajadores.add(trabajador);
        return trabajador;
    }
}
