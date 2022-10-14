package fabrica.trabajador;

import fabrica.shared.Horario;
import fabrica.shared.TipoActividad;
import fabrica.shared.TipoHorario;

public class TrabajadorTecnico extends Trabajador{

    private String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public TrabajadorTecnico(int idTrabajador, String nombre) {
        super(idTrabajador, nombre, TipoActividad.TECNICO);
    }

    @Override
    public void registrarDatos(String ocupacion) {
        this.ocupacion = ocupacion;
        this.horario = new Horario(TipoHorario.HORARIO_TURNOS);
    }
}
