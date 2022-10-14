package fabrica.organizacion;

import fabrica.trabajador.Trabajador;
import fabrica.trabajador.TrabajadorDocente;

public class OrganizacionAcademica extends Organizacion{

    public OrganizacionAcademica(String nombre, String nivel, int limiteTrabajadores) {
        super(nombre, nivel, limiteTrabajadores);
    }

    @Override
    public Trabajador getTrabajador() {
        if(this.trabajadores.size() >= this.limiteTrabajadores)
            throw new RuntimeException("Se ha intentado exceder el límite de trabajadores en" + this.nombre);
        Trabajador trabajador = new TrabajadorDocente(Trabajador.generarId(), "Docente");
        this.trabajadores.add(trabajador);
        return trabajador;
    }
}
