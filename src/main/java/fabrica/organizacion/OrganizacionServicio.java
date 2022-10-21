package fabrica.organizacion;

import fabrica.trabajador.Trabajador;
import fabrica.trabajador.TrabajadorTecnico;

import java.util.Vector;

public class OrganizacionServicio extends Organizacion{

    @Override
    public String[] getActvidades() {
        return new String[]{"Reparación", "Programación", "Instalación", "Planificación"};
    }

    public OrganizacionServicio(String nombre, String nivel, int limiteTrabajadores, int horaEntrada, int horaSalida) {
        super(nombre, nivel, limiteTrabajadores, horaEntrada, horaSalida);
    }

    @Override
    public Trabajador getTrabajador() {
        if(this.trabajadores.size() >= this.limiteTrabajadores)
            throw new RuntimeException("Se ha intentado exceder el límite de trabajadores en" + this.nombre);
        Trabajador trabajador = new TrabajadorTecnico(Trabajador.generarId(), "Técnico");
        this.trabajadores.add(trabajador);
        return trabajador;
    }

    @Override
    public Vector<Trabajador> getTrabajadores(int n) {
        return generarTrabajadores(n, "Tecnico ", 4000);
    }
}
