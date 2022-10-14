package fabrica.organizacion;

import fabrica.trabajador.Trabajador;
import fabrica.trabajador.TrabajadorTecnico;

public class OrganizacionServicio extends Organizacion{

    public OrganizacionServicio(String nombre, String nivel, int limiteTrabajadores) {
        super(nombre, nivel, limiteTrabajadores);
    }

    @Override
    public Trabajador getTrabajador() {
        if(this.trabajadores.size() >= this.limiteTrabajadores)
            throw new RuntimeException("Se ha intentado exceder el límite de trabajadores en" + this.nombre);
        Trabajador trabajador = new TrabajadorTecnico(Trabajador.generarId(), "Técnico");
        this.trabajadores.add(trabajador);
        return trabajador;
    }
}
