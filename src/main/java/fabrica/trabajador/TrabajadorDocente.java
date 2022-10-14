package fabrica.trabajador;

import fabrica.shared.Horario;
import fabrica.shared.TipoActividad;
import fabrica.shared.TipoHorario;

import java.util.Vector;

public class TrabajadorDocente extends Trabajador{

    private Vector<String> materias;

    public TrabajadorDocente(int idTrabajador, String nombre) {
        super(idTrabajador, nombre, TipoActividad.DOCENCIA);
    }

    @Override
    public void registrarDatos(String ocupacion) {
        this.horario = new Horario(TipoHorario.CONTEO_HORAS);
        this.ocupacion = ocupacion;
    }

    public Vector<String> getMaterias() {
        return materias;
    }

    public void agregarMateria(String materia) {
        this.materias.add(materia);
    }
}
